package scripts;
import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import genericlib.DatabaseUtilies;
import genericlib.Projectpojo;
import io.restassured.http.ContentType;
public class CreateaRepro extends BaseClass{
	
	@Test
	public void post() throws SQLException {
		String exprepoName="Gitproject5554567";

	Projectpojo p=new Projectpojo(exprepoName);
		JSONObject p1=new JSONObject();
		p1.put("name",p);
		
	given()
	.contentType(ContentType.JSON)
	.auth().oauth2("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")
	.body(p1.toJSONString())
	.when()
	.post("baseurl/user/repos")
	.then()
	.assertThat().statusCode(201)
	.and()
	.log().all();
	String dbvalue = DatabaseUtilies.queryexecute("select * from repors",2,exprepoName);
	Assert.assertEquals(exprepoName,dbvalue);
	}
	

}
