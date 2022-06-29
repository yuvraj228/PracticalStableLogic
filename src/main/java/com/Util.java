package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	public static void sendkeys(WebDriver driver, By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public static void click(WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}

	public static void scrollIntoView(WebDriver driver, By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void implicitlyWait(WebDriver driver, long milliseconds) {
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
	}

	public static void explicitWait(WebDriver driver, int seconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static String getTextOfElement(WebDriver driver, By locator) {
		return driver.findElement(locator).getText();
	}
}
