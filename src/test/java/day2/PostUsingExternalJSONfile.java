package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PostUsingExternalJSONfile {

	@Test(priority=1)
	void testPostUsingJsonFile() throws FileNotFoundException
	{
		System.out.println("Current working directory: " + new File(".").getAbsolutePath());
		File f = new File("C:\\Users\\Lenovo\\git\\repository\\RestAssured\\src\\test\\java\\day2\\body.json"); // Ensure the file is in the current working directory

		
//		File f = new File(".\\body.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data  = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString()).
			when().
			post("http://localhost:3000/students")
			.then().statusCode(201)
			.body("name",equalTo("Bob Johnson"))
			.body("phone",equalTo("987-654-3210"))
			.body("location",equalTo("Los Angeles"))
			.body("courses[0]",equalTo("Biology"))
			.body("courses[1]",equalTo("Chemistry"))
			.header("Content-Type","application/json").log().all();
		
		
		//.jsonPath().getInt("id");
		
		}

	@Test(priority=2)
	void testDelete()
	{
		Response response=given().
		when().delete("http://localhost:3000/students/b1f6")
		.then().statusCode(200).extract().response();
		
		System.out.println("response:"+response.asString());
		
	}
}
