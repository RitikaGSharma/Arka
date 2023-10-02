package arka.testcases;

import org.testng.annotations.Test;

import arka.base.BaseClass;
import arka.dataProvider.CustomDataProvider;
import arka.pages.Leadspage;
import arka.pages.Loginpagen;

public class AddLead extends BaseClass
{
@Test(dataProvider = "leadData",dataProviderClass = CustomDataProvider.class)
public void addNewLead(String uname,String pass,String Lname,String Lowner,String Lemail,String LphnNo,String Lproperty,String LeadSource,String Pipeline,String Stage)
{
	Loginpagen login=new Loginpagen(driver);
	login.loginToApplication(uname,pass);
	Leadspage leadspage = new Leadspage(driver);
	leadspage.addLead(Lname, Lowner, LphnNo, Lemail, Lproperty, LeadSource, Pipeline, Stage);
}
}
