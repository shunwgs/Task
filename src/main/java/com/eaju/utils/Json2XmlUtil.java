package com.eaju.utils;

import com.alibaba.fastjson.JSONObject;

public class Json2XmlUtil {
    public static String JsonToXml(String json){
        System.out.println("json to xml");
        System.out.println(json);
        JSONObject parseJsonObject = JSONObject.parseObject(json);
        StringBuffer sb = new StringBuffer("<xml><p>");  
        for(String key : parseJsonObject.keySet()){  
            sb.append("<").append(key).append(">");  
            Object value = parseJsonObject.get(key);  
            //判断value是否含有JSONArray  
            JSONObject jsonV = ((JSONObject)value);  
            for(String key2 : jsonV.keySet()){  
                sb.append("<").append(key2).append(">");  
                Object value2 = jsonV.get(key2);  
                sb.append(value2);  
                sb.append("</").append(key2).append(">");  
            }  
            sb.append("</").append(key).append(">");  
        }  
        sb.append("</p></xml>");   
        return sb.toString();  
    }
    
    
}
