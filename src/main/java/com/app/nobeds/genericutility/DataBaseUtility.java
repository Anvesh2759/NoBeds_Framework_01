package com.app.nobeds.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtility implements PathConstants
{
	Connection cn;
	Statement stmt;
	public Connection createConnection()
	{
	
		try 
		{
			cn=DriverManager.getConnection(db_url, db_un, db_pwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
		
	}
	/**
	 * used to print complete table data 
	 * @param query
	 */
	public void readDataFromDataBase(String query)
	{
		try 
		{
			stmt = cn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			int count = result.getMetaData().getColumnCount();
			while (result.next()) 
			{
				for(int i=1;i<=count;i++)
				{
					System.out.print(result.getString(i)+" ");
					
				}
				System.out.println(" ");
				
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void addDataIntoTable(String query)
	{
		try 
		{
			stmt = cn.createStatement();
			stmt.executeUpdate(query);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void closeConnection()
	{
		try 
		{
			cn.close();
		} 
		catch (SQLException e) 
		{
			
		}
	}
	

}
