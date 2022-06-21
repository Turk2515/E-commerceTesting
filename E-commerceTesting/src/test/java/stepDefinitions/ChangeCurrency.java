package stepDefinitions;

import classPages.ChangeCurrencyPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeCurrency {
    ChangeCurrencyPage currency = new ChangeCurrencyPage();
    WebDriver driver = null;
    //@Given("^open site$")
    @Before
    public void openSite() throws InterruptedException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver =new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        Thread.sleep(2000);
    }
    @When("^change currency$")
    public void changeCurrency(){
        currency.changeCurrencyById(driver,"customerCurrency").click();
        currency.changeCurrencyByXPath(driver,"//*[@id=\"customerCurrency\"]/option[2]").click();
    }


    @Then("^ensure that euro is selected")
    public void ensureThatEuroIsSelected(){
        Boolean actualResult= currency.changeCurrencyByXPath(driver,"//*[@id=\"customerCurrency\"]/option[2]").isSelected();
        Boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @After
    public void closeSite(){
        driver.quit();
    }
}
