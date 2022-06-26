package stepDefinitions;

import classPages.SearchProductPage;
import hooksClass.HooksClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class searchProduct {
    SearchProductPage search = new SearchProductPage();
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
        search.searchById(driver,"small-searchterms").click();
        search.searchById(driver,"small-searchterms").sendKeys("nike");
        search.searchById(driver,"small-searchterms").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }


    @Then("ensure the search is valid")
    public void assertOfSearch() throws InterruptedException {
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/search?q=nike";
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(2000);
    }




}
