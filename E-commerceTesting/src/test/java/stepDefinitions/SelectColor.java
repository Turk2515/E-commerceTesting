package stepDefinitions;

import classPages.SelectColorPage;
import hooksClass.HooksClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectColor {
    SelectColorPage color = new SelectColorPage();
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
        color.colorById(driver,"small-searchterms").click();
        color.colorById(driver,"small-searchterms").sendKeys("adidas");
        color.colorById(driver,"small-searchterms").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("^select product and color")
    public void selectProduct() throws InterruptedException {
        color.colorByCssSelector(driver,"a[href=\"/adidas-consortium-campus-80s-running-shoes\"").click();
        Thread.sleep(2000);
        color.colorByXPath(driver,"//*[@id=\"color-squares-10\"]/li[2]/label/span/span").click();
    }


    @Then("ensure the search is valid")
    public void assertOfSearch() throws InterruptedException {
        Boolean actualResult = color.colorByCssSelector(driver,"img[src=\"https://demo.nopcommerce.com/images/thumbs/0000054_adidas-consortium-campus-80s-running-shoes_550.jpg\"]").isDisplayed();
        Boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(2000);
    }



}
