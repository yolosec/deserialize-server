package com.klinec.deserialize.server;

import org.hjson.JsonValue;
import org.json.JSONObject;

/**
 * Created by dusanklinec on 01.09.16.
 */
public class Utils {
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static JSONObject parseJSON(String json){
        return new JSONObject(JsonValue.readHjson(json).toString());
    }

}
