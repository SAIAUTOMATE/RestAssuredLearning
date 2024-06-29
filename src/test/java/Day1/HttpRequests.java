package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HttpRequests {

	/*
given-cookies,autontication, content type
when-reqest type-post and all
then validations--
*/
	@Test
	void getUser()
	{
		//import static packages--whch cant be seen on mouse over 
		//get--https://reqres.in/api/users?page=2

/*/post --https://reqres.in/api/users - {
	    "name": "morpheus",
	    "job": "leader"
	}*/

	given()
	.when().get("https://reqres.in/api/users?page=2").
	then().statusCode(200).body("page",equalTo(2)).log().all();
	}
	
}
