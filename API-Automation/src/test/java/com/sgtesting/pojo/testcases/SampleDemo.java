package com.sgtesting.pojo.testcases;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleDemo {

	public static void main(String[] args) {
		jsonObject1();
	//	jsonArrayObject1();
	}

	private static void jsonObject1()
	{
	//	Login obj=new Login("gowtham","welcome123");

		Login obj=new Login();
		obj.setUserName("Gowtham");
		obj.setPassword("Welcome123");
		try
		{
			ObjectMapper objJson=new ObjectMapper();
			String textContent=objJson.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

			System.out.println(textContent);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void jsonArrayObject1()
	{
		Login[] obj= {
				new Login("gowtham","welcome123"),
				new Login("Manjunath","demo123"),
				new Login("Shivashnakar","testing123")
		};

		try
		{
			ObjectMapper objJson=new ObjectMapper();
			String textContent=objJson.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

			System.out.println(textContent);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
