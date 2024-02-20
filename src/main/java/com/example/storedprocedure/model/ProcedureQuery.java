package com.example.storedprocedure.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "json-data")

public class ProcedureQuery {

	private String procedureName;
	private List<Variable> variables;
	private List<Query> queries;

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public List<Query> getQueries() {
        return queries;
    }

    public void setQueries(List<Query> queries) {
        this.queries = queries;
    }

    public static class Variable {
        private String variableName;
        private String variableType;

        public String getVariableName() {
            return variableName;
        }

        public void setVariableName(String variableName) {
            this.variableName = variableName;
        }

        public String getVariableType() {
            return variableType;
        }

        public void setVariableType(String variableType) {
            this.variableType = variableType;
        }
    }

    public static class Query {
        private String queryType;
        private List<SelectColumn> selectColumns;
        private String fromTable;
        private List<Join> joins;
        private List<WhereCondition> where;
        private OrderBy orderBy;

        public String getQueryType() {
            return queryType;
        }

        public void setQueryType(String queryType) {
            this.queryType = queryType;
        }

        public List<SelectColumn> getSelectColumns() {
            return selectColumns;
        }

        public void setSelectColumns(List<SelectColumn> selectColumns) {
            this.selectColumns = selectColumns;
        }

        public String getFromTable() {
            return fromTable;
        }

        public void setFromTable(String fromTable) {
            this.fromTable = fromTable;
        }

        public List<Join> getJoins() {
            return joins;
        }

        public void setJoins(List<Join> joins) {
            this.joins = joins;
        }

        public List<WhereCondition> getWhere() {
            return where;
        }

        public void setWhere(List<WhereCondition> where) {
            this.where = where;
        }

		public OrderBy getOrderBy() {
			return orderBy;
		}

		public void setOrderBy(OrderBy orderBy) {
			this.orderBy = orderBy;
		}

    }

    public static class SelectColumn {
        private String originalColumn;
        private String aliasName;
        private String operation;

        public String getOriginalColumn() {
            return originalColumn;
        }

        public void setOriginalColumn(String originalColumn) {
            this.originalColumn = originalColumn;
        }

        public String getAliasName() {
            return aliasName;
        }

        public void setAliasName(String aliasName) {
            this.aliasName = aliasName;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }
    }

    public static class Join {
        private String joinType;
        private List<JoinTable> joinTables;

        public String getJoinType() {
            return joinType;
        }

        public void setJoinType(String joinType) {
            this.joinType = joinType;
        }

        public List<JoinTable> getJoinTables() {
            return joinTables;
        }

        public void setJoinTables(List<JoinTable> joinTables) {
            this.joinTables = joinTables;
        }
    }

    public static class JoinTable {
        private String table1Name;
        private String table2Name;
        private String table1_AliasName;
        private String table2_AliasName;
        private String tableName1_PrimaryKey;
        private String tableName2_PrimaryKey;
        private String joinCondition;
		public String getTable1Name() {
			return table1Name;
		}
		public void setTable1Name(String table1Name) {
			this.table1Name = table1Name;
		}
		public String getTable2Name() {
			return table2Name;
		}
		public void setTable2Name(String table2Name) {
			this.table2Name = table2Name;
		}
		public String getTable1_AliasName() {
			return table1_AliasName;
		}
		public void setTable1_AliasName(String table1_AliasName) {
			this.table1_AliasName = table1_AliasName;
		}
		public String getTable2_AliasName() {
			return table2_AliasName;
		}
		public void setTable2_AliasName(String table2_AliasName) {
			this.table2_AliasName = table2_AliasName;
		}
		public String getTableName1_PrimaryKey() {
			return tableName1_PrimaryKey;
		}
		public void setTableName1_PrimaryKey(String tableName1_PrimaryKey) {
			this.tableName1_PrimaryKey = tableName1_PrimaryKey;
		}
		public String getTableName2_PrimaryKey() {
			return tableName2_PrimaryKey;
		}
		public void setTableName2_PrimaryKey(String tableName2_PrimaryKey) {
			this.tableName2_PrimaryKey = tableName2_PrimaryKey;
		}
		public String getJoinCondition() {
			return joinCondition;
		}
		public void setJoinCondition(String joinCondition) {
			this.joinCondition = joinCondition;
		}

        
    }

    public static class WhereCondition {
        private String joinBy;
        private List<Conditions> conditions;

        public String getJoinBy() {
            return joinBy;
        }

        public void setJoinBy(String joinBy) {
            this.joinBy = joinBy;
        }

        public List<Conditions> getConditions() {
            return conditions;
        }

        public void setConditions(List<Conditions> conditions) {
            this.conditions = conditions;
        }
    }

    public static class Conditions {
        private String condition;
        private String column1_name;
        private String column1_type;
        private String column2_name;
        private String column2_type;
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getColumn1_name() {
			return column1_name;
		}
		public void setColumn1_name(String column1_name) {
			this.column1_name = column1_name;
		}
		public String getColumn1_type() {
			return column1_type;
		}
		public void setColumn1_type(String column1_type) {
			this.column1_type = column1_type;
		}
		public String getColumn2_name() {
			return column2_name;
		}
		public void setColumn2_name(String column2_name) {
			this.column2_name = column2_name;
		}
		public String getColumn2_type() {
			return column2_type;
		}
		public void setColumn2_type(String column2_type) {
			this.column2_type = column2_type;
		}

    }

    public static class OrderBy {
        private List<OrderByColumn> columns;
        private String orderType;
        
        public List<OrderByColumn> getColumns() {
            return columns;
        }

        public void setColumns(List<OrderByColumn> columns) {
            this.columns = columns;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }
    }

    public static class OrderByColumn {
        private String columns;
        private String orderType;
		public String getColumns() {
			return columns;
		}
		public void setColumns(String columns) {
			this.columns = columns;
		}
		public String getOrderType() {
			return orderType;
		}
		public void setOrderType(String orderType) {
			this.orderType = orderType;
		}
        
    }
}