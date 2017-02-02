package com.eaju.po;

import java.util.List;

public class OrderEntity {

	private String OUT_ORDER_SN;// 外部订单号

	private String SHIP_NAME;// 客户姓名

	private String SHIP_MOBILE;// 客户电话

	private String SHIP_ADDRESS;// 客户地址

	private String NEED_INSTALL;// 是否需要安装

	private String MEMO;// 备注

	private String INVOICE_INFO;// 发票信息

	private String WORK_ORDER_ID;// 订单状态

	private List<ITEM> ITEM;// 明细

	public void setOUT_ORDER_SN(String OUT_ORDER_SN) {
		this.OUT_ORDER_SN = OUT_ORDER_SN;
	}

	public String getOUT_ORDER_SN() {
		return this.OUT_ORDER_SN;
	}

	public void setSHIP_NAME(String SHIP_NAME) {
		this.SHIP_NAME = SHIP_NAME;
	}

	public String getSHIP_NAME() {
		return this.SHIP_NAME;
	}

	public void setSHIP_MOBILE(String SHIP_MOBILE) {
		this.SHIP_MOBILE = SHIP_MOBILE;
	}

	public String getSHIP_MOBILE() {
		return this.SHIP_MOBILE;
	}

	public void setSHIP_ADDRESS(String SHIP_ADDRESS) {
		this.SHIP_ADDRESS = SHIP_ADDRESS;
	}

	public String getSHIP_ADDRESS() {
		return this.SHIP_ADDRESS;
	}

	public void setNEED_INSTALL(String NEED_INSTALL) {
		this.NEED_INSTALL = NEED_INSTALL;
	}

	public String getNEED_INSTALL() {
		return this.NEED_INSTALL;
	}

	public void setMEMO(String MEMO) {
		this.MEMO = MEMO;
	}

	public String getMEMO() {
		return this.MEMO;
	}

	public void setINVOICE_INFO(String INVOICE_INFO) {
		this.INVOICE_INFO = INVOICE_INFO;
	}

	public String getINVOICE_INFO() {
		return this.INVOICE_INFO;
	}

	public void setWORK_ORDER_ID(String WORK_ORDER_ID) {
		this.WORK_ORDER_ID = WORK_ORDER_ID;
	}

	public String getWORK_ORDER_ID() {
		return this.WORK_ORDER_ID;
	}

	public void setITEM(List<ITEM> ITEM) {
		this.ITEM = ITEM;
	}

	public List<ITEM> getITEM() {
		return this.ITEM;
	}

}