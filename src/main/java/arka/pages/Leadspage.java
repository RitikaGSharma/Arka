package arka.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import arka.helper.Utility;

public class Leadspage 
{
	
	WebDriver driver;
	String fullName="";
			
	
	 public Leadspage(WebDriver driver) 
	 {
	
		this.driver=driver;
	}
	 
private By leadIcon= By.xpath("(//span[@class='icon'])[2]");
private By createLead=By.xpath("//span[normalize-space()='Create Lead']");
private By name=By.xpath("//input[@placeholder='Enter Name']");


private By owner=By.xpath("//input[@placeholder='Select an Owner']");

private By ownerList=By.xpath("//div[@x-placement='bottom-start']//ul[@class='el-scrollbar__view el-select-dropdown__list']//li");


private By email=By.xpath("//input[@placeholder='Enter Email ID']");
private By phoneNo=By.xpath("//input[@placeholder='Enter phone number']");

private By property=By.xpath("//input[@placeholder='Select a property type']");
private By propertyList=By.xpath("//div[@x-placement='bottom-start']//ul[@class='el-scrollbar__view el-select-dropdown__list']//li");
private By leadsource=By.xpath("//input[@placeholder='Select a lead source type']");
private By sourceList=By.xpath("//div[@x-placement='bottom-start']//ul[@class='el-scrollbar__view el-select-dropdown__list']//li");
private By pipeLine=By.xpath("//input[@placeholder='Select a Pipeline']");
private By pipeLineListBy=By.xpath("//div[@x-placement='bottom-start']//ul[@class='el-scrollbar__view el-select-dropdown__list']//li");
private By stage=By.xpath("//input[@placeholder='Select a Stage']");
private By stageList=By.xpath("//span[text()='Lead']//ancestor::ul//span");
private By address=By.xpath("//input[@placeholder='Enter the property address']");
private By addressChoice=By.xpath("//body/div[@class='pac-container pac-logo']/div[1]/span[2]");
private By closeDate=By.xpath("//input[@placeholder='Select Date']");
private By date=By.xpath("//span[normalize-space()='12']");
private By cost=By.xpath("//input[@placeholder='Enter potential deal value']");
private By createBtn=By.xpath("//button[@class='el-button leadBtn el-button--primary']");
private By leadGenerated=By.xpath("//p[@class='name']");

public void addLead(String lName,String lOwner,String lEmail,String lPhnNo,String lProperty,String leadSource,String lPipeline,String lStage,String lAddress,String lcost)
{  
	fullName=lName;
	Utility.waitForWebElement(driver, leadIcon).click();
	Utility.waitForWebElement(driver, createLead).click();
	Utility.waitForWebElement(driver, name).sendKeys(lName);
	Utility.waitForWebElement(driver, owner).click();
	Utility.selectValueFromList(driver, ownerList, lOwner);
	
	Utility.waitForWebElement(driver, email).sendKeys(lEmail);
	Utility.waitForWebElement(driver, phoneNo).sendKeys(lPhnNo);
	Utility.waitForWebElement(driver, property).click();
	Utility.selectValueFromList(driver, propertyList, lProperty);
	Utility.waitForWebElement(driver, leadsource).click();
	Utility.selectValueFromList(driver, sourceList, leadSource);
	Utility.waitForWebElement(driver, pipeLine).click();
	Utility.selectValueFromList(driver, pipeLineListBy, lPipeline);
	Utility.waitForWebElement(driver, stage).click();
	Utility.selectValueFromList(driver, stageList, lStage);
	Utility.waitForWebElement(driver, address).sendKeys(lAddress);
	Utility.selectValueFromList(driver, addressChoice, lAddress);
	Utility.waitForWebElement(driver, closeDate).click();
	Utility.waitForWebElement(driver, date).click();
	Utility.waitForWebElement(driver, cost).sendKeys(lcost);
	Utility.waitForWebElement(driver, createBtn).click();


}
public boolean leadGenerated()
{
	boolean status=false;
	
	try
	{
	
		Utility.waitForWebElement(driver, leadGenerated).getText().contains(fullName);
		status=true;
	}
	catch(NoSuchElementException e)
	{
		
	}
	return status;
	
}
}
