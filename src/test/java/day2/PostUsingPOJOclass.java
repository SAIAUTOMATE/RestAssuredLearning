package day2;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class PostUsingPOJOclass {

	 int id;
	@Test(priority=1)
	void testPostusingHashMap()
	{
		Pojo_PostRequest data = new Pojo_PostRequest();
			data.setName("Krishna");
			data.setLocation("France");
			data.setPhone("8099872");
			String coursesArr[] = {"jbl","api test"};
			data.setCourses(coursesArr);
			
		given().contentType("application/json").body(data).
			when().
			post("http://localhost:3000/students")
			.then().statusCode(201)
			.body("name",equalTo("Krishna"))
			.body("phone",equalTo("8099872"))
			.body("location",equalTo("France"))
			.body("courses[0]",equalTo("jbl"))
			.body("courses[1]",equalTo("api test"))
			.header("Content-Type","application/json").log().all();
		
		
		//.jsonPath().getInt("id");
		
		}

	@Test
	void testDelete()
	{
		Response response=given().
		when().delete("http://localhost:3000/students/3")
		.then().statusCode(200).extract().response();
		
		System.out.println("response:"+response.asString());
		
	}
}
