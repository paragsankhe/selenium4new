package com.seleniumfeatures;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Features1 {
	
	  @Test public void takeElementScreenshot() throws IOException {
	  
	  WebDriverManager.chromedriver().setup(); WebDriver driver = new
	  ChromeDriver(); driver.get("https://www.facebook.com");
	  driver.manage().window().maximize(); WebElement logo =
	  driver.findElement(By.xpath(
	  "/html/body/div[1]/div[2]/div/div/div/div/div[1]/h1/a/i")); File file =
	  logo.getScreenshotAs(OutputType.FILE); File destfile = new
	  File("screenshots\\logo.png"); FileUtils.copyFile(file, destfile);
	  driver.quit();
	  
	  }
	  
	  @Test public void openNewTabWindow() {
	  
	  WebDriverManager.chromedriver().setup(); WebDriver driver = new
	  ChromeDriver(); driver.get("https://www.facebook.com");
	  driver.manage().window().maximize();
	  
	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.navigate().to("https://www.google.com");
	  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.navigate().to("https://www.google.com"); driver.quit();
	  
	  }
	 

	@Test
	public void getHeightWidthXYcordinates() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebElement logo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/h1/a/i"));
		System.out.println("Height is " + logo.getRect().getDimension().getHeight());
		System.out.println("Width is " + logo.getRect().getDimension().getWidth());
		System.out.println("X is " + logo.getRect().getX());
		System.out.println("Y is " + logo.getRect().getY());

		driver.quit();

	}

}
