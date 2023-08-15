package common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
	//1.직접 값을 지정한 경우
	
	//2. 프로퍼티 로드
	//   static 내에서는 this 사용 못하므로, 별도의 파일 읽기용 내부 클래스 작성해서 사용하도록 함
	/*
	private static class ReadProperties { 
		
		private Properties prop;
		
		public ReadProperties() {
			prop = new Properties();
			
			try {
				prop.load(new InputStreamReader(
						this.getClass().getResourceAsStream("dbdriver.properties")));
				//자원과 스트림연결
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public Properties getProp() {
			return prop;
		}
	}
	
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Properties prop = new ReadProperties().getProp();
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("user"), 
					prop.getProperty("passwd"));
			conn.setAutoCommit(false);
					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	*/
	
	//3. 톰캣이 제공하는 DBCP(DataBase Connection Pool)을 이용
	//xml파일로 설정값만 주면 됨
	//contents directory : 프로젝트/src/main/webapp
	//webapp/META-INF/context.xml 파일에 
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			//context.xml에 설정된 <Resource> 엘리먼트의 값들을 이용해서 
			//DBCP를 통해서 Connection을 얻어옴
			//톰캣의 DBCP를 통해서 Connection을 얻어옴
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/oraDB");
			
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.rollback();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) rset.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
