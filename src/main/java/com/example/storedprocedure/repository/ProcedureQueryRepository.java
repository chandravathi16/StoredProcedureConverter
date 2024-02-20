package com.example.storedprocedure.repository;


import com.example.storedprocedure.model.ProcedureQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcedureQueryRepository extends MongoRepository<ProcedureQuery, String> {
    
	
}