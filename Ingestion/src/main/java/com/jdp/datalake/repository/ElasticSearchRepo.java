package com.jdp.datalake.repository;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jdp.datalake.entity.ProductCuratedStoreRequest;


@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<ProductCuratedStoreRequest, String> {
	
	   @Query
	    List<ProductCuratedStoreRequest> FindBySupplierName(@Param(value = "suppliername") String suppliername);
	   
	    @Query
	    List<ProductCuratedStoreRequest> findByStatus(@Param(value = "status") String status);

	   
}
