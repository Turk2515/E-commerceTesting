package stepDefinitions;

import classPages.SelectTagPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelectTag {
    SelectTagPage tag = new SelectTagPage();
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

    @When("^press on category$")
    public void pressOnCategory() throws InterruptedException {
        tag.tagByCssSelector(driver,"a[href=\"/apparel\"").click();
        Thread.sleep(2000);
    }
    @And("^select a tag$")
    public void selectTag() throws InterruptedException {
        tag.tagByCssSelector(driver,"a[href=\"/awesome\"").click();
        Thread.sleep(2000);
    }

    @Then("^ensure a tag is selected")
    public void isTagSelected(){
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/awesome";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @After
    public void closeSite(){
        driver.quit();
    }
}
