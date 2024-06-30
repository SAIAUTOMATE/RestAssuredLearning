package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequests {

	 int id;

	/*
given-cookies,autontication, content type
when-reqest type-post and all
then validations--
*/
	@Test(priority=1)
	void getUser()
	{
		/*/import static packages--whch cant be seen on mouse over 
		//get--https://reqres.in/api/users?page=2

/ /post --https://reqres.in/api/users - {
	    "name": "morpheus",
	    "job": "leader"
	}*/

	given()
	.when().get("https://reqres.in/api/users?page=2").
	then().statusCode(200).body("page",equalTo(2)).log().all();
	}
	
	@Test(priority=2)
	void createUser()
	
	{
		HashMap data=new HashMap();
		
		data.put("name","pavan");
		data.put("job","trainer");

		
		id=given()
		.contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
//		.then().statusCode(201).log().all();
		
		System.out.println("id value is : "+id);
		

	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateID()
	{
		HashMap data=new HashMap();
		
		data.put("name","sai");
		data.put("job","it engineer");

		given().contentType("application/json").body(data)
		.when().put("https://reqres.in/api/users/"+id)
		.then().statusCode(1).log().all();
		

	}
	@Test(priority=4)
	void deleteUser()
{
	
given()
.when().delete("https://reqres.in/api/users/"+id)
.then().statusCode(204).log().all();

}
}