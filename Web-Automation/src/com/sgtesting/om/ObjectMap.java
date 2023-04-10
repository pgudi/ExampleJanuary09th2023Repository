package com.sgtesting.om;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	public static Properties prop=null;
	public ObjectMap(String filename)
	{
		FileInputStream fin=null;
		try
		{
			fin=new FileInputStream(filename);
			prop=new Properties();
			prop.load(fin);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public By getLocator(String logicalName)
	{
		By by=null;
		try
		{
			String locator=prop.getProperty(logicalName);
			System.out.println(locator);
			String[] locatorArray=locator.split(";");
			String locatorName=locatorArray[0];
			String locatorValue=locatorArray[1];
			System.out.println(locatorName+" --> "+locatorValue);
			switch (locatorName.toLowerCase()) {
			case "xpath":
				by=By.xpath(locatorValue);
				break;
			case "id":
				by=By.id(locatorValue);
				break;
			case "name":
				by=By.name(locatorValue);
				break;
			case "cssselector":
				by=By.cssSelector(locatorValue);
				break;
			case "tagname":
				by=By.tagName(locatorValue);
				break;
			case "linktext":
				by=By.linkText(locatorValue);
				break;
			case "partiallinktext":
				by=By.partialLinkText(locatorValue);
				break;
			case "classname":
				by=By.className(locatorValue);
				break;
			default:
				break;
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return by;
	}

}
