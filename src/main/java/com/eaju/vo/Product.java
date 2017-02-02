package com.eaju.vo;

import java.io.Serializable;

/**
 * 商品信息
 * @author MrDuan
 *
 */
public class Product implements Serializable{

	private static final long serialVersionUID = -2042643025832750119L;

	/**
	 * 商品编码
	 */
	private String productSn;
	
	/**
	 * 商品外部编号
	 */
	private String outProductSn;
	
	/**
	 * 商品名称
	 */
	private String productName;
	
	/**
	 * 数量
	 */
	private int quantity;
	
	public String getProductSn() {
		return productSn;
	}
	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}
	public String getOutProductSn() {
		return outProductSn;
	}
	public void setOutProductSn(String outProductSn) {
		this.outProductSn = outProductSn;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
