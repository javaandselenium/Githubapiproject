package scripts;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import genericlib.BaseClass;

public class GetTheProjectDetails extends BaseClass{
	@Test
	public void  getproject() {
		given()
		.auth().oauth2(" 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")
		.pathParam("ownername","javaandselenium")
		.pathParam("reponame","gitdemo")
		.when()
		.get(baseurl+"/repos/{ownername}/{reponame}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
