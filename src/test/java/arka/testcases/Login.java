package arka.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import arka.base.BaseClass;
import arka.dataProvider.CustomDataProvider;
import arka.pages.Leadspage;
import arka.pages.Loginpagen;

public class Login extends BaseClass 
{
	@Test(dataProvider = "userData",dataProviderClass = CustomDataProvider.class)
	public void loginWithValidCredentials(String uname,String pass)
	{
		Loginpagen login=new Loginpagen(driver);
		
		login.loginToApplication(uname,pass);
		
		Assert.assertTrue(login.isUserLoggedIn(),"Login failed");

}
	@Test(dataProvider = "leadData",dataProviderClass = CustomDataProvider.class)
	public void addNewLead(String uname,String pass,String name,String owner,String email,String phnNo,String property,String leadSource,String pipeline,String stage,String address,String cost)
	{

		Loginpagen login=new Loginpagen(driver);
		login.loginToApplication(uname,pass);
		Leadspage leadspage = new Leadspage(driver);
		leadspage.addLead(name,owner, email,phnNo, property, leadSource, pipeline, stage,address,cost);
		Assert.assertTrue(leadspage.leadGenerated(),"New lead generated");
	}
}
