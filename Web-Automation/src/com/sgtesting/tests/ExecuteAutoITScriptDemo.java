package com.sgtesting.tests;

public class ExecuteAutoITScriptDemo {
	public static void main(String[] args) {
		executeAutoIT();
	}
	
	private static void executeAutoIT()
	{
		try
		{
			Runtime obj=Runtime.getRuntime();
			obj.exec("C:\\ExampleAutomation\\AutoIT\\SaveContentInFile.exe");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
