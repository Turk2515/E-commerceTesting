package stepDefinitions;

import classPages.SelectColorPage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelectColor {
    SelectColorPage color = new SelectColorPage();
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


    @After
    public void closeSite(){
        driver.quit();
    }
}
