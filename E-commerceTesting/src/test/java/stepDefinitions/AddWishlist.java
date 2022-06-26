package stepDefinitions;

import classPages.AddWishlistPage;
import hooksClass.HooksClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddWishlist {
    AddWishlistPage wishlist = new AddWishlistPage();
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

    @When("^press on search bar")
    public void pressOnSearchBar() throws InterruptedException {
        wishlist.addWishlistById(driver,"small-searchterms").click();
        wishlist.addWishlistById(driver,"small-searchterms").sendKeys("adidas");
        wishlist.addWishlistById(driver,"small-searchterms").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("^select product and color")
    public void selectProduct() throws InterruptedException {
        wishlist.addWishlistByCssSelector(driver,"a[href=\"/adidas-consortium-campus-80s-running-shoes\"").click();
        wishlist.addWishlistByXPath(driver,"//*[@id=\"color-squares-10\"]/li[2]/label/span/span").click();
        Thread.sleep(2000);
    }

    @And("^select size$")
    public void selectSize(){
        wishlist.addWishlistById(driver,"product_attribute_9").click();
        wishlist.addWishlistByXPath(driver,"//*[@id=\"product_attribute_9\"]/option[4]").click();
    }


    @And("^add product to wishlist$")
    public void addProductToWishList(){
        wishlist.addWishlistById(driver,"add-to-wishlist-button-25").click();
    }
    @Then("^ensure the product added to wishlist$")
    public void addToWishlist() throws InterruptedException {
        String actualResult = wishlist.addWishlistByXPath(driver,"//*[@id=\"bar-notification\"]/div/p/text()").getText();
        String expectedResult = "The product has been added to your ";
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(2000);
    }


}
