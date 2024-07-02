package day3;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParaments {

	//https://reqres.in/api/users?page=2&id=5
	@Test
	void GETtestQueryAndPathParameters()
	{
		
		given().pathParam("mypath", "users")
		.queryParam("page", "5").queryParam("id", "8")
		.when().get("https://reqres.in/api/{mypath}")
		.then().statusCode(200).log().all();

		
	}
	
	
}
