package com.jdp.datalake.entity;

import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;

@Document(indexName = "Product", type = "productdetails")
public class ProductCuratedStoreRequest {
	
	@Field(type = Keyword)
	int id;
	@Field(type = Keyword)
	String name;
	@Field(type = Keyword)
	String category;
	@Field(type = Keyword)
	Date expiry;
	@Field(type = Keyword)
	String suppliername;
	@Field(type = Keyword)
	long ingestionid;
	public ProductCuratedStoreRequest(int id, String name, String category, Date expiry, String suppliername,
			long ingestionid) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.expiry = expiry;
		this.suppliername = suppliername;
		this.ingestionid = ingestionid;
	}
	
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
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public long getIngestionid() {
		return ingestionid;
	}
	public void setIngestionid(long ingestionid) {
		this.ingestionid = ingestionid;
	}
	
	

}
