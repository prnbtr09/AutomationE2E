package petstore;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStore {

    @Test
    public void getJsonData(){
        given().baseUri("https://petstore.swagger.io").
                basePath("/v2").
                accept("application/json").
        when().
                get("pet/111").
        then().
                assertThat().statusCode(200).
                body("status",equalTo("available"));
    }
    @Test
    public void getXMLData(){
        given().
                baseUri("https://petstore.swagger.io").
                basePath("/v2").
                accept("application/xml").
        when().
                get("/pet/111").
        then().
                assertThat().statusCode(200).
                body("Pet.status",equalTo("available"));

    }

}
