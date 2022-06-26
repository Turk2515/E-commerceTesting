package stepDefinitions;

import classPages.AddToCartPage;
import hooksClass.HooksClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddtoCart {
    AddToCartPage cart = new AddToCartPage();
    WebDriver driver = null;
    HooksClass setup = new HooksClass();
    HooksClass close = new HooksClass();
    @Before
    public void site_setup(){
        setup.importDriver();
    }
    @After
    public void closeSite(){
        close.quite();
    }


    @When("^press on search bar$")
    public void pressOnSearchBar() throws InterruptedException {
        cart.addToCartById(driver,"small-searchterms").click();
        cart.addToCartById(driver,"small-searchterms").sendKeys("adidas");
        cart.addToCartById(driver,"small-searchterms").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("^select product and color$")
    public void selectProduct() throws InterruptedException {
        cart.addToCartByCssSelector(driver,"a[href=\"/adidas-consortium-campus-80s-running-shoes\"").click();
        cart.addToCartByXPath(driver,"//*[@id=\"color-squares-10\"]/li[2]/label/span/span").click();
        Thread.sleep(2000);
    }

    @And("^select size$")
    public void selectSize(){
        cart.addToCartById(driver,"product_attribute_9").click();
        cart.addToCartByXPath(driver,"//*[@id=\"product_attribute_9\"]/option[4]").click();

    }


    @And("^press on add to cart$")
    public void pressOnAddToCart(){cart.addToCartById(driver,"add-to-cart-button-25").click();}

    @Then("^ensure the product is added to cart$")
    public void isAddedToCart() throws InterruptedException {
        String actualResult = cart.addToCartByXPath(driver,"//*[@id=\"bar-notification\"]/div/p").getText();
        String expectedResult = "The product has been added to your ";
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(2000);
        driver.quit();
    }


}
