package com.codechallenge.pom.pages;

import com.codechallenge.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Base {

    //Locators
    By product = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]");
    By buttonAddtoCart = By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]");
    By buttonCkeckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    By numberOfProduct = By.xpath("//*[@id=\"summary_products_quantity\"]");
    By buttonDelete = By.xpath("//*[@id=\"1_1_0_0\"]");
    By messageCartEmpty = By.xpath("//*[@id=\"center_column\"]/p");
    By searchBox = By.xpath("//*[@id=\"search_query_top\"]");
    By itemsFounds = By.className("heading-counter");
    By storeInformation = By.xpath("//*[@id=\"block_contact_infos\"]/div/h4");
    By addressText = By.xpath("//*[@id=\"block_contact_infos\"]/div/ul/li[1]");
    By numberPhone = By.xpath("//*[@id=\"block_contact_infos\"]/div/ul/li[2]/span");
    By emailAddress = By.xpath("//*[@id=\"block_contact_infos\"]/div/ul/li[3]/span/a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String addToCart() {
        WebDriverWait wait=new WebDriverWait(driver, 5);
        Actions action = new Actions(driver);
        WebElement weProduct = driver.findElement(product);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weProduct);
        action.moveToElement(weProduct).moveToElement(driver.findElement(buttonAddtoCart)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCkeckout));
        WebElement weAddtoCart = driver.findElement(buttonCkeckout);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weAddtoCart);
        action.moveToElement(weAddtoCart).moveToElement(driver.findElement(buttonCkeckout)).click().build().perform();
        WebElement weNumberofProduct = driver.findElement(numberOfProduct);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weNumberofProduct);
        return getText(weNumberofProduct);
    }

    public String deleteFromCart(){
        WebDriverWait wait=new WebDriverWait(driver, 5);
        Actions moveTo = new Actions(driver);
        WebElement weDelete = driver.findElement(buttonDelete);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weDelete);
        moveTo.moveToElement(weDelete).moveToElement(driver.findElement(buttonDelete)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageCartEmpty));
        WebElement weMessageEmpty = driver.findElement(messageCartEmpty);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weMessageEmpty);
        return getText(weMessageEmpty);
    }

    public String searchItem(String itemToSearch){
        WebElement weSerarchBox = driver.findElement(searchBox);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weSerarchBox);
        findElement(searchBox).clear();
        type(itemToSearch,searchBox);
        findElement(searchBox).submit();
        WebElement weFindItem = driver.findElement(itemsFounds);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weFindItem);
        return getText(weFindItem);
    }

    public List<String> validateStoreInformation(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement weStoreInformation = driver.findElement(storeInformation);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", weStoreInformation);
        List<String> information = new ArrayList<>();
        WebElement weAddressText = driver.findElement(addressText);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weAddressText);
        information.add(getText(weAddressText));
        WebElement weNumberPhone = driver.findElement(numberPhone);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weNumberPhone);
        information.add(getText(weNumberPhone));
        WebElement weEmailAddress = driver.findElement(emailAddress);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", weEmailAddress);
        information.add(getText(weEmailAddress));
        return information;
    }
}