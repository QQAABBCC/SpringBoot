package com.ispan.springbootdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
@Entity
@Table(name="shopLiquor")
public class shopCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "pName")
	private String pName;
	
	@Column(name = "pImg")
	private byte[] pImg;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "Introduce")
	private String Introduce;
	
	@Column(name = "price")
	private String price;
	
	
	public shopCart() {
	}

	
	public shopCart(Integer id, String pName, byte[] pImg, String place, String introduce, String price) {
		super();
		this.id = id;
		this.pName = pName;
		this.pImg = pImg;
		this.place = place;
		this.Introduce = introduce;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public byte[] getpImg() {
		return pImg;
	}


	public void setpImg(byte[] pImg) {
		this.pImg = pImg;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getIntroduce() {
		return Introduce;
	}


	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

	
}
