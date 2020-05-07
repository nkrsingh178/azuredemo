package com.jdp.datalake.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdp.datalake.entity.IngestionRecord;
import com.jdp.datalake.exception.ResourceNotFoundException;
import com.jdp.datalake.services.IngestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/fix")
@Api(value="Curation centre", description="avaible operations to fix the data") 
public class IngestionTrackController {
	
	
	@Autowired
	private IngestionService cservice;
	
//	@Autowired
//	private CuratedStoreRepo crepo;
	
	@ApiOperation(value = "view list of failed ingestion and fix it details via rest", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	}
	)
	@GetMapping(value = "/getAllingestionlist")
	public List<IngestionRecord> getAllIngestion(){
		return cservice.getAllIngestion();
	}
	
	
	@ApiOperation(value = "Retrive ingestion failed data for edit", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved "),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	}
	)
	@GetMapping(value = "/get/{id}")
	public  ResponseEntity<IngestionRecord> getFailedById(String id) throws ResourceNotFoundException {
				IngestionRecord record =cservice.getFailedById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
				return ResponseEntity.ok().body(record);
	   }
	
	
	@ApiOperation(value = "Retrive ingestion  data Based on diffrent status", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved "),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	}
	)
	@GetMapping(value = "/get/{status}")
	public List<IngestionRecord> getRecordBySatus(String status){
		return cservice.getRecordBySatus(status);
	}
	
//	@ApiOperation(value = "Search ingestion  record  Based on suppliername", response = Iterable.class)
//	@ApiResponses(value = {
//	        @ApiResponse(code = 200, message = "Successfully retrieved "),
//	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//	}
//	)
//	@GetMapping(value = "/search/{suppliername}")
//	public List<ProductCuratedStoreRequest> searchRecord(String id){
//		return crepo.FindBySupplierName(id);
//	}
//	
//	@ApiOperation(value = "Search ingestion  record  Based on status", response = Iterable.class)
//	@ApiResponses(value = {
//	        @ApiResponse(code = 200, message = "Successfully retrieved "),
//	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//	}
//	)
//	@GetMapping(value = "/search/{status}")
//	public List<ProductCuratedStoreRequest> searchRecordBystatus(String Status){
//		return crepo.FindBySupplierName(Status);
//	}
}
