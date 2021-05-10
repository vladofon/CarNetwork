package ua.com.foxminded.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {    
	
	public static List<String> getInfo() {
		
		List<String> result = new ArrayList<String>();

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
		        "postgres", "root")) {
			System.out.println("Java JDBC PostgreSQL Example");
		    
		    System.out.println("Connected to PostgreSQL database!");
		    
		    Statement statement = connection.createStatement();  
		    
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM cars.cars");
		    
		    while (resultSet.next()) 
		    {
		        result.add(resultSet.getString("name"));
		    }        
		} catch (SQLException e) 
		{
		    System.out.println("Connection failure.");
		    e.printStackTrace();
		}
		return result;    
	}
	
	public static void insert(String req)
	{
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root")) {
			
			System.out.println("Trying to insert");
			
			Statement stmt = connection.createStatement();
			
			String SQL = "INSERT INTO cars.cars(name, price) VALUES ('" + req + "', 1000)";
			
			ResultSet resultSet = stmt.executeQuery(SQL);
			
			//getInfo();
			
		
		} catch (SQLException e) 
		{
		    System.out.println("Connection failure.");
		    e.printStackTrace();
		}
	}
	
	public static void delete(String req)
	{
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root")) {
			
			System.out.println("Trying to delete");
			
			Statement stmt = connection.createStatement();
			
			String SQL = "DELETE FROM cars.cars WHERE name = " + "'" + req + "'";
			
			System.out.println(SQL);
			
			ResultSet resultSet = stmt.executeQuery(SQL);
			
			//getInfo();
			
		
		} catch (SQLException e) 
		{
		    System.out.println("Connection failure.");
		    e.printStackTrace();
		}
	}
}