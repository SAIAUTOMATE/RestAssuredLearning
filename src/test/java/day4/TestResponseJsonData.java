package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class TestResponseJsonData {
    
    @Test(enabled = false)
    void parsingJsonResponse() {
        // Approach 1
        
        given().contentType("application/json")
        .when().get("http://localhost:3000/Store")
        .then().statusCode(200)
        .header("Content-Type", equalTo("application/json"))
        .body("book[4].title", equalTo("The Hobbit"));
    }

    @Test
    void parsingJsonResponse2() {
        // Approach 1
        
    	Response res =
        given().contentType("application/json")
        .when().get("http://localhost:3000/Store");
    	
    	Assert.assertEquals(res.getStatusCode(), 200);
    	Assert.assertEquals(res.header("Content-Type"),"application/json");
    	
    	String bookname=res.jsonPath().get("book[3].title").toString();
    	
    	Assert.assertEquals(bookname, "Pride and Prejudice");
        //.then().statusCode(200)
        //.header("Content-Type", equalTo("application/json"))
       // .body("book[4].title", equalTo("The Hobbit"));
    }

}
