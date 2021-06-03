package scripts;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class DeleteTherepro {
	@Test
	public void delete() {
		given()
		.auth().oauth2(" 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")
		.when()
		.pathParam("ownername","javaandselenium")
		.pathParam("reponame","Gitproject555")
		.delete("/repos/{ownername}/{reponame}")
	.then()
	.assertThat().statusCode(200)
	.log().all();
	}

}
