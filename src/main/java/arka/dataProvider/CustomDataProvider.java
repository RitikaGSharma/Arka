package arka.dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider 
{
	@DataProvider(name="userData")
	public static Object[][] getUserData()
	{
		Object arr[][]=ExcelReader.getData("Users");
		
		return arr;
	}
	
	@DataProvider(name="leadData")
		public static Object[][] getCustomerData()
	{
		Object arr[][]=ExcelReader.getData("Customers");
		
		return arr;
	}
}
