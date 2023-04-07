package com.sgtesting.tests;
interface Employee
{
	void showJobName(String name);
}

interface Department
{
	void showDepartmentName(String name);
}

class Person implements Employee,Department
{
	public void showJobName(String name)
	{
		System.out.println("Employee Name :"+name);
	}
	
	public void showDepartmentName(String name)
	{
		System.out.println("Department Name :"+name);
	}
}
public class InterfaceDemo {
	public static void main(String[] args) {
		Employee emp=new Person();
		emp.showJobName("SalesMan");
		
		Department dept=(Department) emp;
		dept.showDepartmentName("Accounting");
	}

}
