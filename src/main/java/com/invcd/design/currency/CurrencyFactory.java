package com.invcd.design.currency;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;

public class CurrencyFactory {

    RateCache rateCache;

    RateService service;

    public CurrencyFactory() {
        this.rateCache = RateCache.getInstance();
        this.service = new RateService();
    }

    public double getRate(String fromCurr, String toCurr) throws JSONException, IOException, InterruptedException {
        Double rate = null;

        if (rateCache.getCache() == null || rateCache.getCache().get(fromCurr) == null
                || rateCache.getCache().get(toCurr) == null) {
            rateCache.populateCache(service.getRates());
        }
        if(rateCache.getBaseCurrency().equals(fromCurr)){// EUR->USD base is EUR 9 eur -> 10 usd 1 eur = 1.1 usd
                rate =  rateCache.getCache().get(toCurr);
        }else if(rateCache.getBaseCurrency().equals(toCurr)){//USD->EUR
                rate = 1-rateCache.getCache().get(fromCurr);
        }else{
            double fromRate = rateCache.getCache().get(fromCurr);//0.9
            double toRate = rateCache.getCache().get(toCurr);//1.1
            rate = Double.valueOf(toRate/fromRate);//1.1/0.9 -> 11/9 -> 1.2
        }

        return rate;
    }
}