package com.eaju.po;

/**
 * 
 * @author shun
 * @date 2017年1月12日 上午11:19:25
 * @Discripition 
 * <p>Company: eaju</p>
 * @version 1.0
 */
public class InsertAPPOrderResult {
    
    private String info;
    
    private Object data;
    //private List<Map<String, Object>> data;
    
    private String returnCode;
    
   

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

  

  

    
}
