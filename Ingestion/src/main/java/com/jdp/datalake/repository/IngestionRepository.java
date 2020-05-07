package com.jdp.datalake.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdp.datalake.entity.IngestionRecord;
@Repository
public interface  IngestionRepository extends JpaRepository<IngestionRecord, Long>{
	
	List<IngestionRecord> findByStatus(String status);
	List<IngestionRecord> findBySupplier(String supplier);
	List<IngestionRecord> findByEntity(String entity);
	
	
}
