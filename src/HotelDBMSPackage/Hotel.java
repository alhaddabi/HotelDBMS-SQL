package HotelDBMSPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class Hotel {
	public static void main(String[] args) {
//		    			        String url = "jdbc:sqlserver://localhost:1433;" +
//		    			                "databaseName=HotelDBMS;" +
//		    			                "encrypt=true;" +
//		    			                "trustServerCertificate=true";
//		    			        String user = "sa";
//		    			        String pass = "root";
//		    			 Connection con = null;
//		    			        try {
//		    			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//		    			DriverManager.registerDriver(driver);
//		    			            con = DriverManager.getConnection(url, user, pass);
//		    			 Statement st = con.createStatement();
		    			 ////////////////////////////// the firts table ////////////////////////////
//		    			 String sql = 
//		    					 "CREATE TABLE Hotels (id INT PRIMARY KEY IDENTITY, " +
//		                         "hotel_name VARCHAR(255) NOT NULL, " +
//		                         "hotel_location VARCHAR(255), " +
//		                         "created_date VARCHAR(255) NOT NULL, " +
//    	                         "updated_date VARCHAR(255), " +
//		                         "is_Active BIT NOT NULL);"
//		    	
//		    		//////////////////////////////////////////the secound table ///////////////////////////
//                                +"CREATE TABLE Room_Type ("+ "id INT PRIMARY KEY ,"
//		                        + "room_type_name VARCHAR(255) NOT NULL,"
//		                        + "created_date VARCHAR(255),"
//		                        + "updated_date VARCHAR(255),"
//		                        + "is_Active BIT NOT NULL);"
//		    			 
//		    			 ///////////////////////////////// the 3 table ///////////////////////////////////////
//		                        +"CREATE TABLE Rooms (\r\n"
//		                        + " id INTEGER PRIMARY KEY,\r\n"
//		                        + " room_type_id INTEGER REFERENCES Room_Type(id),\r\n"
//		                        + " hotel_id INTEGER REFERENCES Hotels(id),\r\n"
//		                        + " created_date VARCHAR(255) NOT NULL,\r\n"
//		                        + " updated_date VARCHAR(255),\r\n"
//		                        + " is_active BIT NOT NULL\r\n"
//		                        + ");\r\n"
//		                        + "\r\n"
//		                        /////////////////////////the 4 table ///////////////////////////////////////////
//		                        + " CREATE TABLE Guests (\r\n"
//		                        + " id INTEGER PRIMARY KEY,\r\n"
//		                        + " guest_name TEXT NOT NULL,\r\n"
//		                        + " guest_phone TEXT NOT NULL,\r\n"
//		                        + " guest_accompanying_members INTEGER NOT NULL,\r\n"
//		                        + " guest_payment_amount INTEGER NOT NULL,\r\n"
//		                        + " room_id INTEGER REFERENCES Rooms(id),\r\n"
//		                        + " hotel_id INTEGER REFERENCES Hotels(id),\r\n"
//		                        + " created_date VARCHAR(255) NOT NULL,\r\n"
//		                        + " updated_date VARCHAR(255),\r\n"
//		                        + " is_active BIT NOT NULL\r\n"
//		                        + ");\r\n"
//		                        + "\r\n"
//		                        ///////////////////////////the 5 table ////////////////////////////////////////////
//		                        + " CREATE TABLE Employee_Type (\r\n"
//		                        + " id INTEGER PRIMARY KEY,\r\n"
//		                        + " employee_type_name TEXT NOT NULL,\r\n"
//		                        + " created_date VARCHAR(255) NOT NULL,\r\n"
//		                        + " updated_date VARCHAR(255),\r\n"
//		                        + " is_active BIT NOT NULL\r\n"
//		                        + ");\r\n"
//		                        + "\r\n"
//		                        /////////////////////////////the 6 table ////////////////////////////////////////////
//		                        + " CREATE TABLE Employees (\r\n"
//		                        + " id INTEGER PRIMARY KEY,\r\n"
//		                        + " employee_name TEXT NOT NULL,\r\n"
//		                        + " employee_phone TEXT NOT NULL,\r\n"
//		                        + " employee_type_id INTEGER REFERENCES Employee_Type(id),\r\n"
//		                        + " room_id INTEGER REFERENCES Rooms(id),\r\n"
//		                        + " created_date VARCHAR(255) NOT NULL,\r\n"
//		                        + " updated_date VARCHAR(255),\r\n"
//		                        + " is_active BIT NOT NULL\r\n"
//		                        + ");";
//		    	            
//		    			
//		    			Integer m = st.executeUpdate(sql);
//		    			            if (m >= 1) {
//		    			System.out.println("inserted successfully : " + sql);
//		    			} else {
//		    			System.out.println("insertion failed");
//		    			}
//		    			 
//		    			            con.close();
//		    			} catch (Exception ex) {
//		    			System.err.println(ex);
//		    			}		    

		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=HotelDBMS;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id");
		int id = scanner.nextInt();
		System.out.println("enter the room type");
		String room_type = scanner.next();
		System.out.println("enter created_date");
		String created_date = scanner.next();
		System.out.println("enter updated_date");
		String updated_date = scanner.next();
		System.out.println("enter is_Active");
		String is_active = scanner.next();
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();

			// String sql = "insert into Table_1 values('" + name+ "'," + roll + ",'" + cls+ "')";
//			String sql = "INSERT INTO Hotels ('" + id + "'," + hotel_name + "'," + hotel_location + "'," + created_date
//					+ updated_date + "'," + is_Active + "')";
			String sql = "INSERT INTO Employee_Type (id, employee_type_name, created_date, updated_date, is_active) " +
                    "VALUES ('" + id + "','" + room_type + "','" + created_date +"','" + updated_date + "','" + is_active + "')";


			Integer m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("insertion failed");
			}
			String sql1 = "Select * from Employee_Type";
			ResultSet resultSet = st.executeQuery(sql1);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(id));
				System.out.println(resultSet.getString(room_type));;
				System.out.println(resultSet.getString(created_date));
				System.out.println(resultSet.getString(updated_date));
				System.out.println(resultSet.getString(is_active));
			}
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

}