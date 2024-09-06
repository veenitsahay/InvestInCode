package com.invcd.design.currency;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Currency;
import java.util.Locale;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class RateService implements IRate{

    public static final String API_BASE_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=ef6f40192e4ce50790217469c7d8a1a4";

    @Override
    public JSONObject getRates() throws JSONException, IOException,
            InterruptedException {
        String apiUrl = API_BASE_URL;

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).GET().build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        JSONObject res = null;

        if(response.statusCode() == HttpURLConnection.HTTP_OK){
             res = new JSONObject(response.body());
        }
        return res;
    }
}
