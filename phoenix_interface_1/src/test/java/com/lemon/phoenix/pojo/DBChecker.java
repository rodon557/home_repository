package com.lemon.phoenix.pojo;

public class DBChecker {
	   private String no;
	   private String sql;
	   private String expectedQueryResult;
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public String getSql() {
			return sql;
		}
		public void setSql(String sql) {
			this.sql = sql;
		}
		public String getExpectedQueryResult() {
			return expectedQueryResult;
		}
		public void setExpectedQueryResult(String expectedQueryResult) {
			this.expectedQueryResult = expectedQueryResult;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "no:【"+no+"】,sql:【"+sql+"】，expectedQueryResult:【"+expectedQueryResult+"】";
		}
		   
}


