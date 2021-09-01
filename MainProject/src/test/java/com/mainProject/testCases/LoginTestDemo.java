package com.mainProject.testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTestDemo extends BaseClass{

	@Test
	public void DemoLoginTest() {
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("55555");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		//deliberately failing test to get screenshot
		assertEquals(false, true);
	}
}
