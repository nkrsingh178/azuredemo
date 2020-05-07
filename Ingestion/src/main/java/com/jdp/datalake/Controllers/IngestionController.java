package com.jdp.datalake.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdp.datalake.entity.ProductRequest;
import com.jdp.datalake.services.IngestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="ingestion  centre", description="avaible operations to ingest  data from diffrence sources") 
@RequestMapping("/api/v1")
public class IngestionController {
	
	
	@Autowired
	private IngestionService service;
	@ApiOperation(value = "ingest the product details via rest")
	@ApiResponses(value = {
	        @ApiResponse(code = 202, message = "Successfully ingested"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	}
	)
	@PostMapping("/product")
	public ProductRequest ingestproduct(@ApiParam(value ="Product information to be created.", required = true) @Valid @RequestBody ProductRequest productrequest) {
		service.Ingest(productrequest);
		return productrequest;
	}

}
