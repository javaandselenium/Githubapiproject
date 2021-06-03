package scripts;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GetTheProjectDetails {
	@Test
	public void  getproject() {
		given()
		.auth().oauth2(" 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")
		.pathParam("ownername","javaandselenium")
		.pathParam("reponame","Gitproject")
		.when()
		.get("/repos/{ownername}/{reponame}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
