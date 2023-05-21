package com.sgtesting.tests.users;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User1 {
	
	public static String user_id=null;
	@Test(priority = 1)
	public void createUser()
	{
		try
		{
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest= RestAssured.given();
			
			File f1=new File(".\\DataFiles\\CreateUser.json");
			
			httpRequest.header("Content-Type","application/json");
			
			httpRequest.body(f1);
			
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

}
