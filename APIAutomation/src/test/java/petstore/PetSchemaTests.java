package petstore;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PetSchemaTests {
    @Test
    public void testScheemaOfPet(){
        given().
                baseUri("https://petstore.swagger.io").
                basePath("/v2").
        when().
                get("/pet/77777").
        then().
                assertThat().statusCode(200).
                body(matchesJsonSchemaInClasspath("Petjsonschema.json"));
    }
}
