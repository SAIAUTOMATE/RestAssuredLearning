package day2;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class WaysToPOSTRequestBody {

	@Test(priority=1)
	void testPostusingHashMap()
	{
		HashMap data=new HashMap();
				data.put("name", "saikrishna");
		data.put("location", "France");
		data.put("phone", "123456");
		String courseArr[]= {"c","java"};
			data.put("courses", courseArr);

			
			given().contentType("application/json").body(data).
			when().
			post("http://localhost:3000/students").
			then().statusCode(201)
			.body("name",equalTo("saikrishna"))
			.body("location",equalTo("France"))
			//.body("courses[0]",equalTo("c"))
			//.body("courses[1]",equalTo("java"))
			.header("Content-Type","application/json").log().all();
	}

	@Test
	void testDelete()
	{
		Response response=given().
		when().delete("http://localhost:3000/students/2")
		.then().statusCode(200).extract().response();
		
		System.out.println("response:"+response.asString());
		
	}
}
