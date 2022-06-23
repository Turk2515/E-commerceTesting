package stepDefinitions;

import classPages.SelectCategoriesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelectCategories {
    WebDriver driver = null;
    SelectCategoriesPage category = new SelectCategoriesPage();
    @Before
    public void site_setup(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver =new ChromeDriver();
    }

    @When("^press on category$")
    public void pressOnCategory() throws InterruptedException {
        category.categoryByCssSelector(driver,"a[href=\"/apparel\"").click();
        Thread.sleep(2000);
    }

    @And("^enter sub-category$")
    public void subCategory() throws InterruptedException {
        category.categoryByXPath(driver,"/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div").click();
        Thread.sleep(2000);
    }

    @Then("^last page of category search$")
    public void lastPageOfCategorySearch() throws InterruptedException {
        String actualResult = category.categoryByXPath(driver,"/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1").getText();
        String expectedResult = "Products tagged with 'awesome'";
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(2000);
    }

    @After
    public void closeSite(){
        driver.quit();
    }
}
