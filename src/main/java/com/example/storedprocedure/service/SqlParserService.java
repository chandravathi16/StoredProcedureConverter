package com.example.storedprocedure.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.procedure.CreateProcedure;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import com.example.storedprocedure.repository.ProcedureQueryRepository;
import com.example.storedprocedure.model.ProcedureQuery;

@Service
public class SqlParserService {

    private final ProcedureQueryRepository procedureQueryRepository; // Inject your repository here

    public SqlParserService(ProcedureQueryRepository procedureQueryRepository) {
        this.procedureQueryRepository = procedureQueryRepository;
    }

    public ProcedureQuery parseSqlToProcedureQuery(String sql) {
        ProcedureQuery procedureQuery = new ProcedureQuery();

        try {
            Statement statement = CCJSqlParserUtil.parse(sql);

            if (statement instanceof CreateProcedure) {
                CreateProcedure createProcedure = (CreateProcedure) statement;

                // Set ProcedureName
                procedureQuery.setProcedureName(createProcedure.getName());

                // You may handle variables here if needed
                // For simplicity, assuming no variables in this example

                // Set Queries
                procedureQuery.setQueries(SqlToQueryParser.parse(createProcedure.getStatement().toString()));
            }

        } catch (JSQLParserException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return procedureQuery;
    }

    public void saveJsonToFile(ProcedureQuery procedureQuery) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(procedureQuery);

            // Save to src/main/resources folder
            String filePath = "src/main/resources/" + procedureQuery.getProcedureName() + ".json";
            File file = new File(filePath);
            objectMapper.writeValue(file, procedureQuery);

        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public void saveProcedureQueryToMongoDB(ProcedureQuery procedureQuery) {
        procedureQueryRepository.save(procedureQuery);
    }
}

