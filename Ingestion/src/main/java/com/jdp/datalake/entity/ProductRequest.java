package com.jdp.datalake.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "Class representing a product tracked by the application.")
public class ProductRequest {
	
	@ApiModelProperty(notes = "id of product. ", example = "1234", required = true, position = 0)
	private  int id;
	@ApiModelProperty(notes = "Unique name  of product. ", example = "Lux", required = true, position = 1)
	private  String name;
	@ApiModelProperty(notes = "category  of product. ", example = "Cosmatic", required = true, position = 2)
	private  String category;
//	@ApiModelProperty(notes = "expiry  of product. ", example = "4-01-1984", required = true, position = 3)
//	private  Date expiry;
	@ApiModelProperty(notes = "suppliername  of product. ", example = "Hindustan Uniliver", required = true, position = 4)
	private  String suppliername;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
//	public Date getExpiry() {
//		return expiry;
//	}
//	public void setExpiry(Date expiry) {
//		this.expiry = expiry;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
	
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public ProductRequest(int id, String name, String category,String suppliername) {
		this.id = id;
		this.name = name;
		this.category = category;
//		this.expiry = expiry;
		this.suppliername = suppliername;
	}
	

}
