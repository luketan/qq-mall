package com.honglinktech.zbgj.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shon on 11/17/15.
 */
public class JsonHelper {
    public static String map2JsonStr(Map<String, Object> map)
            throws IOException {
        if (map.size() == 0)
            return "{}";

        //Map<String, Object> resultMap = null;
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();

        objectMapper.writeValue(stringWriter, map);

        String str = stringWriter.toString();

        return str;
    }

    public static Map<String, Object> jsonStr2Map(String json) throws IOException {
        if (json == null || json.isEmpty())
            return new LinkedHashMap<String, Object>();

        StringReader stringReader = new StringReader(json);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(stringReader, new TypeReference<Map<String, Object>>() {
        });
    }

    public static List<Object> jsonStr2Array(String json) throws IOException {
        if (json == null || json.isEmpty())
            return new ArrayList<Object>();

        StringReader stringReader = new StringReader(json);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(stringReader, new TypeReference<List<Object>>() {
        });
    }

    public static String object2JsonStr(Object obj)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();

        objectMapper.writeValue(stringWriter, obj);

        String str = stringWriter.toString();

        return str;
    }
}
