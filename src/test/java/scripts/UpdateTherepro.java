package scripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class UpdateTherepro {
	@Test
	public void patch() {
		JSONObject j=new JSONObject();
		j.put("private",true);
		
		given()
		.contentType(ContentType.JSON)
		.body(j)
		.auth().oauth2(" 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")
		.when()
		.pathParam("ownername","javaandselenium")
		.pathParam("reponame","Gitproject555")
		.patch("/repos/{ownername}/{reponame}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}

}
