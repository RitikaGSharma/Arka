package arka.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import arka.helper.Utility;

public class AddTaskpage {
	WebDriver driver;
	
	public AddTaskpage(WebDriver driver) 
	 {
	
		this.driver=driver;
	}
	
	private By taskIcon=By.xpath("(//span[@class='icon'])[3]");
	private By createTaskIcon=By.xpath("//button[@type='button']//span[contains(text(),'Create Task')]");
	private By taskName=By.xpath("//input[@placeholder='Task Name']");
	private By startDate=By.xpath("(//input[@placeholder='Select a date'])[1]");

	private By dueDate=By.xpath("(//input[@placeholder='Select a date'])[2]");

	private By homeOwner=By.xpath("//input[@placeholder='Enter a homeowner']");
	private By homeOwnerList=By.xpath("//div[@x-placement='bottom-start']//ul[@class='el-scrollbar__view el-select-dropdown__list']//li");
	private By fileUploadIcon=By.xpath("//img[@class='addIcon']");
	private By taskDescription=By.xpath("//textarea[@placeholder='What is this task about?']");
	private By selectFile=By.xpath("//input[@type='file']");
	private By uploadSaveBtn=By.xpath("//button[@class='el-button submitBtn el-button--primary']");
	private By createTaskBtn=By.xpath("//span[normalize-space()='Create']");
	private By searchTask=By.xpath("//input[@class='searchInput']");
	private By uploadDelBtn=By.xpath("//img[@class='delBtn']");
	private By taskSearch=By.xpath("(//input[contains(@placeholder,'Please Input')])");
	private By listIcon=By.xpath("(//img[contains(@class,'typeIcon')])[2]");
	
	public void addTask(String lName,String lStartDate,String lDueDate,String lTaskDescription,String lTaskName)
	{
		Utility.waitForWebElement(driver, taskIcon).click();
		Utility.waitForWebElement(driver, createTaskIcon).click();
		Utility.waitForWebElement(driver, taskName).sendKeys(lTaskName);
	
		Utility.waitForWebElement(driver, startDate).click();
		Utility.waitForWebElement(driver, By.xpath("//span[normalize-space()='"+lStartDate+"']")).click();
		
		//Utility.selectValueFromList(driver, startDateList, lStartDate);
		Utility.waitForElement(driver, dueDate).click();
		Utility.waitForWebElement(driver, By.xpath("(//span[normalize-space()='"+lDueDate+"'])[2]")).click();
		Utility.waitForWebElement(driver, homeOwner).click();
		Utility.selectValueFromList(driver, homeOwnerList, lName);
		Utility.waitForWebElement(driver, taskDescription).sendKeys(lTaskDescription);
		Utility.waitForWebElement(driver, fileUploadIcon).click();
		String paths=System.getProperty("user.dir");
		String filePath = paths +"/TestData/demo.png";
		//System.out.println(filePath);
	
		
		 WebElement ele= driver.findElement(selectFile);
		LocalFileDetector detector = new LocalFileDetector();
		String path =new File(filePath).getAbsolutePath();
		File file = detector.getLocalFile(path);
		((RemoteWebElement) ele).setFileDetector(detector);
		ele.sendKeys(file.getAbsolutePath());
		
		
		//Utility.waitForWebElement(driver, selectFile).sendKeys(filePath);
		
		//driver.findElement(selectFile).sendKeys(filePath);
		Utility.wait(2);
		//Utility.waitForWebElement(driver, selectFile).sendKeys(filePath);
		Utility.waitForWebElement(driver, uploadSaveBtn).click();
		Utility.waitForWebElement(driver, uploadDelBtn).isDisplayed();
		Utility.waitForWebElement(driver, createTaskBtn).click();
		Utility.waitForWebElement(driver, searchTask).sendKeys(lName);
	Utility.waitForWebElement(driver, listIcon).click();
		Utility.selectValueFromList(driver, taskSearch, lTaskName);
		
	}
	 
	public boolean istaskCreated(String lTaskName)
	{
		boolean status=false;
		
		try
		{
			
			driver.findElement(taskSearch).getText().contains(lTaskName);
			status=true;
		}
		catch(NoSuchElementException e)
		{
			
		}
		return status;
		
	}
	 }

