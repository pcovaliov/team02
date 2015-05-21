package com.endava.endavainternship.service;

import java.util.Random;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
  private static WebDriver driver;
  private String baseUrl = "http://localhost:8080/endavainternship/login";
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private static String generatedUserEmail;

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();
		Random r = new Random();
		int randomNumber = r.nextInt(99999 + 1);
		generatedUserEmail = "test" + randomNumber +"@mail.com";
  }

  @Test
  public void seleniumTest() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("testasd");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("testasd");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("testasd@testasd.com");
    driver.findElement(By.name("image")).sendKeys("C:\\Users\\alevitchi\\Desktop\\IMG_6735-155x155.jpg");
    driver.findElement(By.cssSelector("button.button.button-block")).click();
    driver.findElement(By.linkText("USERS")).click();
    //verify user exists in the table 
    driver.findElement(By.linkText("HOME")).click();
    driver.findElement(By.id("message")).clear();
    driver.findElement(By.id("message")).sendKeys("testasd");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("LOGOUT")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
