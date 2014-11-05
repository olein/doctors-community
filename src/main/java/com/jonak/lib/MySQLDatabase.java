package com.jonak.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MySQLDatabase 
{
	String table;
	ArrayList fields = new ArrayList();
	ArrayList types = new ArrayList();
	ArrayList values = new ArrayList();
	Connection conn;
	public Connection DBconnection() 
	{
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "mydb";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password1 = "";
		Connection conn = null;
		try {
			// mysql load driver
			Class.forName(driver).newInstance();

			conn = DriverManager.getConnection(url + dbName, userName,
					password1);
			System.out.println("Connected to the database");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.print("failed\n");
		}
		return conn;
	}
	
	public void closeConnection(Connection conn) throws SQLException
	{
		 try {
			 conn.close();
			 System.out.println("closed");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }		
	}
	
	public ResultSet executeSelectQuery(String tableName, String field,ArrayList fields,
			ArrayList type, ArrayList values) throws SQLException 
	{
		conn = DBconnection();
		
		
		String sql = " select " + field + " from " + tableName + " ";
		
		int size = fields.size();

		if (size > 0) {
			sql += " where ";
			for (int i = 0; i < fields.size(); i++) {
				sql += fields.get(i)+"=? ";
				if (i < fields.size() - 1) 
				{
					sql += " and ";
				}				
			}
		}
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		System.out.println(sql);
		for (int i = 0; i < fields.size(); i++)
		{
			if (type.get(i).equals("String")) 
			{
				String result = (String) values.get(i);
				preparedStatement.setString(i + 1, result);
			}
			if (type.get(i).equals("int")) 
			{
				int result = (Integer) values.get(i);
				preparedStatement.setInt(i + 1, result);
			}
			if (type.get(i).equals("long")) 
			{
				long result = (Long) values.get(i);
				preparedStatement.setLong(i + 1, result);
			}
		}
		
		ResultSet rs = preparedStatement.executeQuery();
				
		return rs;
	}
	
	public String add(String table, ArrayList fields, ArrayList type,
			ArrayList values) throws SQLException 
	{
		
		conn = DBconnection();
		String sql = "insert into " + table + "(";

		for (int i = 0; i < fields.size(); i++) 
		{
			sql += fields.get(i);
			if (i < fields.size() - 1) 
			{
				sql += ",";
			}
		}
		sql += ") values(";

		for (int i = 0; i < fields.size(); i++) 
		{
			sql += "?";
			if (i < fields.size() - 1)
			{
				sql += ",";
			}
		}
		sql += ")";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
	
		for (int i = 0; i < fields.size(); i++)
		{
			if (type.get(i).equals("String")) 
			{
				String result = (String) values.get(i);
				preparedStatement.setString(i + 1, result);
			}
			if (type.get(i).equals("int")) 
			{
				int result = (Integer) values.get(i);
				preparedStatement.setInt(i + 1, result);
			}
			if (type.get(i).equals("long")) 
			{
				long result = (Long) values.get(i);
				preparedStatement.setLong(i + 1, result);
			}
		}

		preparedStatement.executeUpdate();

		closeConnection(conn);
		
		return "success";
	}
	
	public String update(String table, ArrayList fields, ArrayList type,
			ArrayList values) throws SQLException 
	{
		conn = DBconnection();
		
		String sql = "update " + table + " set ";

		for (int i = 0; i < fields.size(); i++) 
		{
			sql += fields.get(i)+"=? ";
			if (i < fields.size() - 1) 
			{
				sql += ",";
			}
		}
		sql += "where id=?";
		System.out.println(sql);
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
	
		for (int i = 0; i < fields.size(); i++)
		{
			if (type.get(i).equals("String")) 
			{
				String result = (String) values.get(i);
				preparedStatement.setString(i + 1, result);
			}
			if (type.get(i).equals("int")) 
			{
				int result =(Integer) values.get(i);
				preparedStatement.setInt(i + 1, result);
			}
		}
		preparedStatement.setInt(fields.size()+1, 6);
		preparedStatement.executeUpdate();

		closeConnection(conn);
		return "success";
	}
	
	public String delete(String table, int id) throws SQLException 
	{
		conn = DBconnection();
		
		String sql = "delete from " + table+" where id=?";
		
		System.out.println(sql);
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		preparedStatement.setInt(1 , id);
		preparedStatement.executeUpdate();

		closeConnection(conn);
		return "success";
	}

}
