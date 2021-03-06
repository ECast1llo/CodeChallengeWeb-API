package com.codechallenge.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    public WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    //Functions
    public WebDriver chromeDriver(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        visit("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        return driver;
    }

    public void visit(String url){
        driver.get(url);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void doClick(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public JavascriptExecutor highLigth(String color, WebElement we){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:"+color+"')", we);
        return jsExecutor;
    }

    public  JavascriptExecutor scrolling(WebElement we){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", we);
        return jsExecutor;
    }

}
