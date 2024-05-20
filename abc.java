import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class abc {
	
	@Test
	void test () {
		RestAssured.baseURI = "https://dev-api-ecom-public.ceductoid.com";
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject data = new JSONObject();
		data.put("username", "watsco");
		data.put("password", "rs05cH3Reb5de6Q7wFfLB9FwEihHOkgDCvSzYSIvK0bX5pQnZ3QY1XVgin81S9pm");
		
		request.header("Content-Type","application/json");
		
		Response responseFromToken = request.request(Method.POST, "/api/v1/authenticate/");  // extract response
		responseFromToken.prettyPrint(); // print the response
		
		// token
		String jsonString = responseFromToken.getBody().asString();
		String tokengenerated = responseFromToken.jsonPath().getJsonObject("token");
		
		//String tokengenerated= JsonPath.from(jsonString).get("token");
		
		request.header("Authorization", "Bearer " + tokengenerated) .header("Content-Type","application/json");
		
		// response
		//Response customerResponse = request.request(Method.GET, "/api/v1/customer/234107?enterprise_num=1&customer_id=234107");
		//customerResponse.prettyPrint(); 
		
		// print the second response
		//String response2 = customerResponse.getBody().asString();
		//System.out.println("Response is: " +response2);
		
		
		
		
		
		
	}

}
