package genericlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtilies {
	public static Connection connection;
	
	public static Connection  connecttodataBase() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		return connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/githubpro","root","root");
		 
		
	}
	
	public static String queryexecute(String query,int colum,String expdata) throws SQLException {
		String actualData="";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(colum).equals(expdata)) {
				actualData=result.getString(colum);
				break;
			}
		}
		return actualData;
	}

	
	public static void closeConnection() throws SQLException {
		connection.close();
	}
}

