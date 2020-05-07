package com.jdp.datalake.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IngestionRecord")
public class IngestionRecord {

	private long id;
	private String status;
	private String entity;
	private String supplier;

	public IngestionRecord() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public IngestionRecord(String status, String entity, String supplier) {
		this.status = status;
		this.entity = entity;
		this.supplier = supplier;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "entity", nullable = false)
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	@Column(name = "supplier", nullable = false)
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "IngestionRecord [status=" + status + ", entity_name=" + entity + ", supplier_name=" + supplier
				+ "]";
	}

}
