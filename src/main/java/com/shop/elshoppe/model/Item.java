package com.shop.elshoppe.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 
	CREATE TABLE ELSHOPPE.ITEM(
		ITEMID SERIAL PRIMARY KEY, 
		ITEMNAME VARCHAR(50) NOT NULL, 
		PRICE NUMERIC(10,2),
		AVAILABLE VARCHAR(1),
		IMAGE VARCHAR(100),
		CREATED_BY VARCHAR(10),
		CREATION_DATE TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
	);
 * 
 */
@Entity
@Table(name = "item")
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itemid")
	private Integer ItemId;
	
	@Column(name = "itemname")
	private String ItemName;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "available")
	private String available;	
	
	@Column(name = "image")
	private String image;	
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "creation_date")
	private Timestamp creationDate;
	
	public Integer getItemId() {
		return ItemId;
	}
	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
}
