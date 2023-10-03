package arka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import arka.helper.Utility;

public class AddTask {
	WebDriver driver;
	
	public AddTask(WebDriver driver) 
	 {
	
		this.driver=driver;
	}
	
	private By taskIcon=By.xpath("(//span[@class='icon'])[3]");
	private By createTaskIcon=By.xpath("//button[@type='button']//span[contains(text(),'Create Task')]");
	private By taskName=By.xpath("//input[@placeholder='Task Name']");
	private By startDate=By.xpath("(//input[@placeholder='Select a date'])[1]");
	private By startDateList=By.xpath("//span[normalize-space()='17']//ancestor::table//span");
	private By dueDate=By.xpath("//input[@placeholder='Select a date'])[2]");
	private By dueDateList=By.xpath("//div[@x-placement='bottom-start']//table[@class='el-date-table']");
	private By homeOwner=By.xpath("//input[@placeholder='Enter a homeowner']");
	private By homeOwnerList=By.xpath("//div[@x-placement='bottom-start']//ul[@class='el-scrollbar__view el-select-dropdown__list']//li");
	private By fileUploadIcon=By.xpath("//img[@class='addIcon']");
	private By taskDescription=By.xpath("//textarea[@placeholder='What is this task about?']");
	
	public void addTask(String lTaskName,String lStartDate,String lDueDate,String lName,String lTaskDescription)
	{
		Utility.waitForWebElement(driver, taskIcon).click();
		Utility.waitForWebElement(driver, createTaskIcon).click();
		Utility.waitForWebElement(driver, taskName).sendKeys(lTaskName);
	
		Utility.waitForWebElement(driver, startDate).click();
		Utility.selectValueFromList(driver, startDateList, lStartDate);
		Utility.waitForElement(driver, dueDate).click();
		Utility.selectValueFromList(driver, dueDateList, lDueDate);
		Utility.waitForWebElement(driver, homeOwner).click();
		Utility.selectValueFromList(driver, homeOwnerList, lName);
		Utility.waitForWebElement(driver, taskDescription).sendKeys(lTaskDescription);
		Utility.waitForWebElement(driver, fileUploadIcon).sendKeys("C:\\Users\\HP\\git\\SeleniumFrameworkMay2023\\TestData");
		
	}
}
