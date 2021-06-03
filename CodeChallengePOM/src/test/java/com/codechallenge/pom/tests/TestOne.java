package com.codechallenge.pom.tests;

import com.codechallenge.pom.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOne {
    private WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        driver = homePage.chromeDriver();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testForPage() throws InterruptedException {
        //Verify that can add item to cart
        Assert.assertEquals(homePage.addToCart(),"1 Product");
        //Verify that can delete 1 item from cart
        Assert.assertEquals(homePage.deleteFromCart(),"Your shopping cart is empty.");
        //Using positive search in searchbar
        Assert.assertTrue(homePage.searchItem("blouse").contains("result has been found."));
        //Using negative search in searchbar
        Assert.assertEquals(homePage.searchItem("corbata"),"0 results have been found.");
        //Validate store information in footer
        //validate address
        Assert.assertEquals(homePage.validateStoreInformation().get(0),"Selenium Framework, Research Triangle" +
                " Park, North Carolina, USA");
        //validate phone
        Assert.assertEquals(homePage.validateStoreInformation().get(1),"(347) 466-7432");
        //validate email
        Assert.assertEquals(homePage.validateStoreInformation().get(2),"support@seleniumframework.com");
    }
}
