package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils;

import com.google.gson.Gson;

public class JsonUtil {

    private static Gson gson = null;

    static {
        gson = new Gson();
    }

    public static String toJson(Object object){
        return gson.toJson(object);
    }
}
