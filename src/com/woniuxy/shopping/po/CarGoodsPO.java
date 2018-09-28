package com.woniuxy.shopping.po;

public class CarGoodsPO {
	private String account;
	private int goodsid;
	private int goodscount;
	private int goodsbalance;
	private int price;
	private String imgsrc; 
	private String goodsname;
	private String brand;
	private String briefintroduction;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBriefintroduction() {
		return briefintroduction;
	}
	public void setBriefintroduction(String briefintroduction) {
		this.briefintroduction = briefintroduction;
	}
	public int getGoodsbalance() {
		return goodsbalance;
	}
	public void setGoodsbalance(int goodsbalance) {
		this.goodsbalance = goodsbalance;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
