package com.eaju.junitTest;

import org.json.JSONObject;

public class JsonBean2XmlString {
    public static String JsonToXml(JSONObject json){
        System.out.println("JsonBean转换成xml:");  
        System.out.println("json:"+json);  
        StringBuffer sb = new StringBuffer("<xml><p>");  
        for(String key : json.keySet()){  
            sb.append("<").append(key).append(">");  
            Object value = json.get(key);  
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
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        People p = new People(001,"xiao");
        People p2 = new People(002,"yao");
        json.put("p1", p); 
        json.put("p2", p2);
        System.out.println(JsonToXml(json));
    }
}
