package auto.septech.databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auto.septech.utilities.PropertiesUtil;
import auto.septech.utilities.TestLogger;

public class ConnectDatabase {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://127.0.0.1:3306/smaport";

	// Database credentials
	public static String dbName="";
	public static String dbUser="";
	public static String dbPassword="";
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void getConnectionInfo() throws IOException{
		dbName = System.getProperty("dbName");
		dbUser = System.getProperty("dbUser");
		dbPassword = System.getProperty("dbPassword");
		if (dbName==null || dbName=="") 
			dbName = PropertiesUtil.load_config_sys().getProperty("db.dbName");
		if (dbUser==null || dbUser=="") 
			dbUser = PropertiesUtil.load_config_sys().getProperty("db.dbUser");
		if (dbPassword==null || dbPassword=="") 
			dbPassword = PropertiesUtil.load_config_sys().getProperty("db.dbPassword");
	}
	
	public static ResultSet executeQuery(String myQueries){
		try {
			TestLogger.info("connect database");
			getConnectionInfo();
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			//DB_URL=DB_URL+dbName;
			conn = DriverManager.getConnection(DB_URL, dbUser, dbPassword);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			rs = stmt.executeQuery(myQueries);
			return rs;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return null;
	}

	public static void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

		}
	}

	public static void executeUpdate(String myQueries) {
		try {
			TestLogger.info("connect database");
			getConnectionInfo();
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			//DB_URL=DB_URL+dbName;
			conn = DriverManager.getConnection(DB_URL, dbUser, dbPassword);

			// STEP 4: Execute a query
			stmt = conn.createStatement();
			stmt.executeUpdate(myQueries);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			TestLogger.info(myQueries);
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
}
