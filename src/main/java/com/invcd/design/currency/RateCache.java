package com.invcd.design.currency;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;

public class RateCache{

    private static HashMap<String,Double> cache;

    private static String baseCurrency;

    private static RateCache instance;

    private RateCache() {
    }

    public static synchronized RateCache getInstance() {
        if (instance == null) {
            instance = new RateCache();
        }
        return instance;
    }


    public static HashMap<String,Double> populateCache(JSONObject jsonObject) throws JSONException, IOException,
            InterruptedException {
        cache = new HashMap<>();

        baseCurrency = String.valueOf(jsonObject.get("base"));

        JSONObject jsonObject1 = (JSONObject) jsonObject.get("rates");
        Iterator iterator = jsonObject1.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            Double value = jsonObject1.getDouble(key);
            cache.put(key,value);
        }

        return cache;
    }

    public HashMap<String, Double> getCache() {
        return  cache;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }
}
