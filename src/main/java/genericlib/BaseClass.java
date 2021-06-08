package genericlib;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public String baseurl;
	@BeforeSuite
	public void setUp() throws SQLException {
		 baseurl="https://api.github.com";
		DatabaseUtilies.connecttodataBase();
	}
	
	
	@AfterSuite
	public void tearDown() throws SQLException {
		DatabaseUtilies.closeConnection();
	}

}
