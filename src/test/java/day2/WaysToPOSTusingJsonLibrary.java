package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class WaysToPOSTusingJsonLibrary {
	@Test(priority=1)
	 void postdatatest()
	{
	 JSONObject data= new JSONObject();
		data.put("name", "krishna");
		data.put("location", "india");
		data.put("phone", "984809812");
		String courseArr[]= {"C++","corejava"};
		data.put("courses", courseArr);

	
	given()
	.contentType("application/json")
	.body(data.toString())
	.when()
	.post("http://localhost:3000/students")
	.then()
	.statusCode(201)
	.body ("name", equalTo("krishna"))
	.body("location", equalTo("india"))
	.body ("phone", equalTo ("984809812"))
	.body("courses[0]", equalTo ("C++"))
	.body("courses[1]",equalTo("corejava"))
	.header("Content-Type","application/json")
	.log().all();
	}
	@Test(priority=2)
	void testDelete()
	{
		given().
		when().delete("http://localhost:3000/students/1")
		.then().statusCode(200);
		
		
	}
}
