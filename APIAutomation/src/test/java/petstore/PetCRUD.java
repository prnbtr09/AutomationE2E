package petstore;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PetCRUD {

//    Category category = new Category( 100, "cat");
//    String[] urls = {"rest.com","test.com"};
//    Pet pet = new Pet("Malli",10005,urls,"pending",category);
    ObjectMapper mapper;
    Pet pet;

    @BeforeTest
    public void setUp() throws IOException {
        System.out.println("Before Test........");
        RestAssured.requestSpecification =
                given().
                        baseUri("https://petstore.swagger.io").
                        basePath("/v2").
                        contentType("application/json");
        mapper=new ObjectMapper();
        pet=mapper.readValue(new File("src/test/resources/pet.json"),Pet.class);
    }

    @Test(priority = 2)
    public void testGet(){
        String  resp = get("pet/12345").
        then().statusCode(200).extract().asPrettyString();
        System.out.println(resp);

    }
    @Test (priority = 3)
    public void testDelete(){
        get("pet/222").
                then().statusCode(200);

    }

    @Test (priority = 1)
    public void testPost() {

        Response response = given().
                body(pet).
                when().
                post("/pet");
        JsonPath jsonPath = response.jsonPath();
        long newid = jsonPath.get("id");
        System.out.println(newid);
        String responseAsString = response.asString();
        String name = JsonPath.from(responseAsString).get("name");
        System.out.println(name);
    }
    @Test (priority = 4)
    public void getDS(){
        System.out.println("getDS-----------------");
        get("/pet/12345").as(Pet.class);
        System.out.println(pet.getName());
    }

    @Test (priority = 5)
    public void allTests(){

        Map<String,Object> petMap = getPetData();
        //creating new Pet

        int newPetId = given().body(petMap).when().post("/pet").path("id");

        //verifying whether the path is available
        get("/pet/"+newPetId).then().statusCode(200).and().body("status",equalTo("pending"));

        //updating pet status to available
        petMap.put("id",newPetId);
        petMap.put("status","available");
        given().body(petMap).when().put("/pet").then().statusCode(200);

        //verifying whether updated pet is available or not
        get("/pet/"+newPetId).then().statusCode(200).and().body("status",equalTo("available"));

        //delete the pet
        delete("/pet/"+newPetId).then().statusCode(200);
        // verify whether pet is deleted
        get("/pet/"+newPetId).then().statusCode(404);

    }
    private Map<String, Object> getPetData(){
        String[] urls = {"rest.com","test.com"};
        Map<String,Object> categoryMap = new HashMap();
        categoryMap.put("id", 1);
        categoryMap.put("name","cat");

        Map<String,Object> petMap = new HashMap<>();
        petMap.put("name","cat-epam");
        petMap.put("id",10003);
        petMap.put("status","pending");
        petMap.put("category",categoryMap);
        petMap.put("photoUrls",urls);
        return petMap;
    }
}
