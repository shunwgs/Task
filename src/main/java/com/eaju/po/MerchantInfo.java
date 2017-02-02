package com.eaju.po;

/**
 * 
 * @author shun
 * @date 2016年12月14日 下午8:41:25
 * @Discripition 商家信息的实体类
 * <p>Company: eaju</p>
 * @version 1.0
 */

public class MerchantInfo {
    
    private String id;
    
    /**
     * 商家token
     */
    private String merchantToken;
    
    /**
     * 密钥
     */
    
    private String merchantKey;
    
    /**
     * 商家类型：1  美标，2 九牧  ，3 中台 ， 4 天猫
     */
     private String merchantType;
    
    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String getMerchantToken() {
        return merchantToken;
    }

    public void setMerchantToken(String merchantToken) {
        this.merchantToken = merchantToken;
    }


    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    @Override
    public String toString() {
        return "MerchantInfo [merchantToken=" + merchantToken +  ", merchantType="
                + merchantType + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
     
     
}
