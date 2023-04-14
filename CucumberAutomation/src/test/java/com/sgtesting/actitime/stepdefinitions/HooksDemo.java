package com.sgtesting.actitime.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksDemo {
	
	@Before
	public void connectToDatabase()
	{
		System.out.println("I connect to the Oracle Database");
	}
	
	@After
	public void disConnectFromDatabase()
	{
		System.out.println("I disconnected from Oracle Database");
	}

}
