package com.example.storedprocedure.service;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.example.storedprocedure.model.ProcedureQuery.SelectColumn;

public class SelectQueryParser {

    public static void parse(Query query, String sql) {
        try {
            Select select = (Select) CCJSqlParserUtil.parse(sql);
            SelectBody selectBody = select.getSelectBody();

            if (selectBody instanceof PlainSelect) {
                PlainSelect plainSelect = (PlainSelect) selectBody;

                // Set QueryType
                query.setQueryType("SELECT");

                // Set SelectColumns
                List<SelectColumn> selectColumns = new ArrayList<>();
                for (SelectItem selectItem : plainSelect.getSelectItems()) {
                    SelectColumn selectColumn = new SelectColumn();
                    selectColumn.setOriginalColumn(selectItem.toString());
                    selectColumns.add(selectColumn);
                }
                query.setSelectColumns(selectColumns);

                // Set FromTable
                query.setFromTable(plainSelect.getFromItem().toString());

                // You may handle Joins, Where, and OrderBy clauses here if needed
                // For simplicity, assuming no Joins, Where, and OrderBy in this example

            } else {
                // Handle other cases if needed
            }

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }
}

