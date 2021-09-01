package com.mainProject.testCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.mainProject.utilities.ReadConfig;


public class BaseClass {


	ReadConfig config=new ReadConfig();
	
	
	public String baseUrl=config.getApplicationUrl();
	public String userName=config.getUserName();
	public String password=config.getPassword();
	public static WebDriver driver;
	static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger=LogManager.getLogger(BaseClass.class.getName());
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
			driver=new ChromeDriver();
		
		}else if (br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", config.getFirefoxDriverPath());
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
	}
	

	public static String getScreenShotPath(String testCaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\ScreenShots\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}


	
}
