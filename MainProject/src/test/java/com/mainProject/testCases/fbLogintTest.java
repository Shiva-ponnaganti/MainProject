package com.mainProject.testCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class fbLogintTest extends BaseClass{

	@Test
	public void fbLogintest() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("5555555");
		driver.findElement(By.name("pass")).sendKeys("00000");
		driver.findElement(By.name("login")).click();
		//deliberately failing test to get screenshot
		assertEquals(true, false);
	}
	
}
