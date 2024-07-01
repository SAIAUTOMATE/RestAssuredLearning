package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	/*@Test(priority=1)
	void GETtestQueryAndPathParameters()
	{
		
		given().
		when().get("https://www.google.com/")
		.then().cookie("AEC", "AQTF6Hw5Vr11cTp5Leu7o_mdsoslo3CLUt5WHE-WNfNzGbaxn_6zMQTPTks")
		.log().all();

	}
	
	@Test(priority=2)
	void GETtestCookieInfo()
	{
		Response res = 
		given().
		when().get("https://www.google.com/");
		String cookie_value=res.getCookie("AEC");
		
		System.out.println("value of copkie is "+cookie_value);
		//.then().cookie("AEC", "AQTF6Hw5Vr11cTp5Leu7o_mdsoslo3CLUt5WHE-WNfNzGbaxn_6zMQTPTks")
		//.log().all();

	}


	*/
	@Test(priority=3)
	void GETtestCookiesInfo()
	{
		Response res = 
		given().
		when().get("https://www.google.com/");
		Map<String,String>cookie_value=res.getCookies();
		
		System.out.println("value of copkie is "+cookie_value.keySet());
		//.then().cookie("AEC", "AQTF6Hw5Vr11cTp5Leu7o_mdsoslo3CLUt5WHE-WNfNzGbaxn_6zMQTPTks")
		//.log().all();

	}


}
