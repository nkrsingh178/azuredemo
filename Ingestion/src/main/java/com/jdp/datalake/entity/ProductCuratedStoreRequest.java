package com.jdp.datalake.entity;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "productind", type = "productuser")
public class ProductCuratedStoreRequest {
	
	int id;
	String name;
	String category;
//	@Field(type = Keyword)
//	String expiry;
	String suppliername;
	long ingestionid;
//	public ProductCuratedStoreRequest(int id, String name, String category, String suppliername,
//			long ingestionid) {
//		this.id = id;
//		this.name = name;
//		this.category = category;
////		this.expiry = expiry;
//		this.suppliername = suppliername;
//		this.ingestionid = ingestionid;
//	}
//	
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
//	public String getExpiry() {
//		return expiry;
//	}
//	public void setExpiry(String expiry) {
//		this.expiry = expiry;
//	}
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
