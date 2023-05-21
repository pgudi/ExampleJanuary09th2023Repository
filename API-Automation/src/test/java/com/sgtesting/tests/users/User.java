package com.sgtesting.tests.users;

import org.testng.annotations.Test;
import java.util.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User {
	public static String user_id=null;
	@Test(priority = 1)
	public void createUser()
	{
		try
		{
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest= RestAssured.given();
			
			Map<String,String> obj=new HashMap<String,String>();
			obj.put("address", "RPC Layout");
			obj.put("emailId", "demo@gmail.com");
			obj.put("firstName", "Demo");
			obj.put("lastName", "User1");
			obj.put("phoneNumber", "9080701020");
			obj.put("userRole", "Automation Architect");
			obj.put("zipcode", "560040");
			
			httpRequest.header("Content-Type","application/json");
			
			httpRequest.body(obj);
			
			Response response=httpRequest.post();
			String content=response.asString();
			System.out.println(content);
			
			JsonPath jpath=response.jsonPath();
			user_id=jpath.getString("id");
			System.out.println("User Id :"+user_id);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 2)
	public void displayParticularUser()
	{
		try
		{
			System.out.println("Display a Particular User using GET http Method");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
			RequestSpecification httpRequest= RestAssured.given();
						
			httpRequest.header("Content-Type","application/json");
						
			Response response=httpRequest.get();
			String content=response.asString();
			System.out.println(content);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
