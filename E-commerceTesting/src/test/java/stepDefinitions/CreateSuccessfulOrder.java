package stepDefinitions;

import classPages.CreateSuccessfulOrderPage;
import hooksClass.HooksClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateSuccessfulOrder {
    CreateSuccessfulOrderPage order = new CreateSuccessfulOrderPage();
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
        order.orderById(driver,"small-searchterms").click();
        order.orderById(driver,"small-searchterms").sendKeys("adidas");
        order.orderById(driver,"small-searchterms").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("^select product and color$")
    public void selectProduct() throws InterruptedException {
        order.orderByCssSelector(driver,"a[href=\"/adidas-consortium-campus-80s-running-shoes\"").click();
        order.orderByXPath(driver,"//*[@id=\"color-squares-10\"]/li[2]/label/span/span").click();
        Thread.sleep(2000);
    }

    @And("^select size$")
    public void selectSize(){
        order.orderById(driver,"product_attribute_9").click();
        order.orderByXPath(driver,"//*[@id=\"product_attribute_9\"]/option[4]").click();
    }


    @And("^press on add to cart$")
    public void pressOnAddToCart(){order.orderById(driver,"add-to-cart-button-25").click();}

    @And("^go to cart$")
    public void goToCart() throws InterruptedException {
        order.orderById(driver,"topcartlink").click();
        Thread.sleep(2000);
        order.orderById(driver,"termsofservice").click();
        order.orderById(driver,"checkout").click();
        Thread.sleep(2000);
    }

    @And("^enter billing address$")
    public void enterBillingAddress(){
        order.orderByXPath(driver,"//*[@id=\"BillingNewAddress_CountryId\"]").click();
        order.orderByXPath(driver,"//*[@id=\"BillingNewAddress_CountryId\"]/option[66]").click();
        order.orderByXPath(driver,"BillingNewAddress_City").sendKeys("Giza");
        order.orderByXPath(driver,"BillingNewAddress_Address1").sendKeys("Giza");
        order.orderByXPath(driver,"BillingNewAddress_ZipPostalCode").sendKeys("12111");
        order.orderById(driver,"BillingNewAddress_PhoneNumber").sendKeys("000000000000");
        order.orderByXPath(driver,"//*[@id=\"billing-buttons-container\"]/button[4]").click();
    }

    @And("^select shipping address$")
    public void selectShippingAddress(){
        order.orderById(driver,"shippingoption_1").click();
        order.orderByXPath(driver,"//*[@id=\"shipping-method-buttons-container\"]/button").click();
    }


    @And("^select payment method$")
    public void selectPaymentMethod(){
        order.orderById(driver,"paymentmethod_0").click();
        order.orderByXPath(driver,"//*[@id=\"payment-method-buttons-container\"]/button").click();
    }

    @And("^confirm order$")
    public void confirmOrder(){
        order.orderByXPath(driver,"//*[@id=\"payment-info-buttons-container\"]/button").click();
        order.orderByXPath(driver,"//*[@id=\"confirm-order-buttons-container\"]/button").click();
    }

    @Then("^success order$")
    public void successOrder(){
        String actualResult = order.orderByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong").getText();
        String expectedResult = "Your order has been successfully processed!";
        Assert.assertEquals(actualResult,expectedResult);
    }



}
