package com.invcd.design.currency;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public interface IRate {

    JSONObject getRates() throws JSONException, IOException, InterruptedException;
}
