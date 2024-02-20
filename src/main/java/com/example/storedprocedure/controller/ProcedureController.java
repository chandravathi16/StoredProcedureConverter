package com.example.storedprocedure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.storedprocedure.service.SqlParserService;
import com.example.storedprocedure.model.ProcedureQuery;

@RestController
public class ProcedureController {

    @Autowired
    private SqlParserService sqlParserService;

    @PostMapping("/parseSql")
    public ResponseEntity<ProcedureQuery> parseSql(@RequestBody String sql) {
        ProcedureQuery procedureQuery = sqlParserService.parseSqlToProcedureQuery(sql);

        // Save procedureQuery to MongoDB
        sqlParserService.saveProcedureQueryToMongoDB(procedureQuery);

        // Save the procedureQuery as JSON to src/main/resources folder
        sqlParserService.saveJsonToFile(procedureQuery);

        return ResponseEntity.ok(procedureQuery);
    }
}
