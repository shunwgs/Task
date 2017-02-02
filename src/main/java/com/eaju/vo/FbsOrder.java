package com.eaju.vo;

import java.io.Serializable;
import java.util.List;

/**
 * FBS订单
 * @author MrDuan
 *
 */
public class FbsOrder implements Serializable{
	
	private static final long serialVersionUID = -89267833897487266L;

	/**
	 * 店铺名称
	 */
	private String storeName;
	
	/**
	 * 发货仓
	 */
	private String warehouse;
	
	/**
	 * 天猫主交易订单号
	 */
	private String bizParentOrderId;
	
	/**
	 * 运单号
	 */
	private String dispatchSn;
	
	/**
	 * 物流公司
	 */
	private String dispatchMemo;
	
	/**
	 * 订单商品
	 */
	private List<Product> productList;
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getBizParentOrderId() {
		return bizParentOrderId;
	}
	public void setBizParentOrderId(String bizParentOrderId) {
		this.bizParentOrderId = bizParentOrderId;
	}
	public String getDispatchSn() {
		return dispatchSn;
	}
	public void setDispatchSn(String dispatchSn) {
		this.dispatchSn = dispatchSn;
	}
	public String getDispatchMemo() {
		return dispatchMemo;
	}
	public void setDispatchMemo(String dispatchMemo) {
		this.dispatchMemo = dispatchMemo;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}
