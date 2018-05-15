package com.honglinktech.zbgj.service.weixin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONUtils
{
    public static JsonObject parseJsonByStream(InputStream in){
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        JsonParser jsonPaser=new JsonParser();
        JsonElement jsonElement=jsonPaser.parse(reader);
        return jsonElement.getAsJsonObject();
    }
    public static JsonObject parseJsonByStr(String str){
        JsonParser jsonPaser=new JsonParser();
        JsonElement jsonElement=jsonPaser.parse(str);
        return jsonElement.getAsJsonObject();
    }
}
