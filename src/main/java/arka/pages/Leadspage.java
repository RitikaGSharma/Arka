package arka.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.Locator;

import arka.helper.Utility;

public class Leadspage 
{
	
	WebDriver driver;
	
	 public Leadspage(WebDriver driver) 
	 {
	
		this.driver=driver;
	}
	 
private By leadIcon= By.xpath("(//span[@class='icon'])[2]");
private By createLead=By.xpath("//span[normalize-space()='Create Lead']");
private By name=By.xpath("//input[@placeholder='Enter Name']");


private By owner=By.xpath("//input[@placeholder='Select an Owner']");

private By ownerList=By.xpath("//div[@x-placement='bottom-start']");


private By email=By.xpath("//input[@placeholder='Enter Email ID']");
private By phoneNo=By.xpath("//input[@placeholder='Enter phone number']");

private By property=By.xpath("//input[@placeholder='Select a property type']");
private By propertyList=By.xpath("//div[@x-placement='bottom-start']");
private By leadsource=By.xpath("//input[@placeholder='Select a lead source type']");
private By sourceList=By.xpath("//div[@x-placement='top-start']");
private By pipeLine=By.xpath("//input[@placeholder='Select a Pipeline']");
private By stage=By.xpath("//input[@placeholder='Select a Stage']");


public void addLead(String lName,String lOwner,String lEmail,String lPhnNo,String lProperty,String leadSource,String lPipeline,String lStage)
{
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
	Utility.waitForWebElement(driver, pipeLine).sendKeys(lPipeline);
	Utility.waitForWebElement(driver, stage).sendKeys(lStage);
	
 // driver.findElement(leadIcon).click();
  //driver.findElement(createLead).click();
 //driver.findElement(name).sendKeys(Lname);
 //driver.findElement(owner).sendKeys(Lowner);
// driver.findElement(email).sendKeys(Lemail);
// driver.findElement(phoneNo).sendKeys(lphnNo);
 //driver.findElement(property).sendKeys(Lproperty);
 //driver.findElement(leadSource).sendKeys(LeadSource);
// driver.findElement(pipeLine).sendKeys(Pipeline);
 //driver.findElement(stage).sendKeys(Stage);
}
}
