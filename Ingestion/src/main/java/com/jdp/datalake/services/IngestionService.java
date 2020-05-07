package com.jdp.datalake.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdp.datalake.entity.IngestionRecord;
import com.jdp.datalake.entity.ProductRequest;
import com.jdp.datalake.entity.TrackStatus;
import com.jdp.datalake.repository.EventHubPublisher;
import com.jdp.datalake.repository.IngestionRepository;

@Service
public class IngestionService {
	
	
	@Autowired
	private IngestionRepository repo;
	@Autowired
	private EventHubPublisher eventhub;
	
	
	public List<IngestionRecord> getAllIngestion(){
		return repo.findAll();
	}
	
	public Optional<IngestionRecord> getFailedById(long id){
		return repo.findById(id);
		
	}
	public List<IngestionRecord> getRecordBySatus(String status){
		return repo.findByStatus(status.toUpperCase());
	}

	public List<IngestionRecord> search(String supliername) {
		return repo.findBySupplier(supliername);
	}

	public void Ingest(@Valid ProductRequest productrequest) {
		IngestionRecord record =new IngestionRecord();
		record.setEntity(productrequest.getClass().getName());
		record.setStatus(TrackStatus.NEW.toString());
		record.setSupplier(productrequest.getSuppliername());
		repo.save(record);
		eventhub.pushEvent(productrequest);
	}
	
}
