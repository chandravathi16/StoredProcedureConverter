package com.example.storedprocedure.service;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

public class SqlToQueryParser {

    public static Query parse(String sql) {
        Query query = new Query();

        try {
            Statement statement = CCJSqlParserUtil.parse(sql);

            if (StringUtils.startsWithIgnoreCase(sql.trim(), "SELECT")) {
                // Handle SELECT queries
                SelectQueryParser.parse(query, statement.toString());
            }

            // You can add support for other query types (INSERT, UPDATE, DELETE) as needed

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return query;
    }
}
