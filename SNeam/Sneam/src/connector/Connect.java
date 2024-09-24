package connector;

import java.sql.Connection;
import java.sql.Statement;

import java.sql.*;

public class Connect {
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE = "sneam";
	private final String HOST = "localhost:3306";
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	
	private Connection con;
	private Statement st;
	
	public ResultSet rs;
	public ResultSetMetaData rsm;
	
	private static Connect connectInstance;
	
	public static Connect getInstance() {
		if(connectInstance == null) {
			return new Connect();
		}
		return connectInstance;
	}
	
	public Connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet execQueryGetData(String query) {
		try {
			rs = st.executeQuery(query);
			rsm = rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void execQueryInUp(String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
