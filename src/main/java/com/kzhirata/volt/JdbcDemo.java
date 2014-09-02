package com.kzhirata.volt;

import java.sql.*;

public class JdbcDemo {

	static final String driver = "org.voltdb.jdbc.Driver";
	static final String url = "jdbc:voltdb://localhost:21212";
	static final String sql = "SELECT visitor_name1 FROM visitor limit 10";

	public static void main(String[] args) {

		try {
			// Load driver. Create connection.
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url);

			// create a statement
			Statement query = conn.createStatement();
			ResultSet results = query.executeQuery(sql);
			while (results.next()) {
				System.out.println("visitor_name1 is " + results.getString(1));
			}

			// call a stored procedure
			CallableStatement proc = conn
					.prepareCall("{call VisitorMailHistory(?)}");
			proc.setString(1, "L0000010");
			results = proc.executeQuery();
			while (results.next()) {
				System.out.printf("%s, %s, %s\n", results.getString(1),
						results.getString(2), results.getTimestamp(3));
			}

			// call a stored procedure
			CallableStatement proc2 = conn
					.prepareCall("{call VisitorTrackingHistory(?)}");
			proc.setString(1, "L0000010");
			results = proc2.executeQuery();
			while (results.next()) {
				System.out.printf("%s, %s, %s\n", results.getString(1),
						results.getString(2), results.getTimestamp(3));
			}
			
			// Close statements, connections, etc.
			query.close();
			proc.close();
			proc2.close();
			results.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}