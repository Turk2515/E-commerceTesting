package stepDefinitions;

import classPages.SearchProductPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class searchProduct {
    SearchProductPage search = new SearchProductPage();
    WebDriver driver = null;
    @Before
    public void openSite() throws InterruptedException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver =new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        Thread.sleep(2000);
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

    @After
    public void closeSite(){
        driver.quit();
    }


}
