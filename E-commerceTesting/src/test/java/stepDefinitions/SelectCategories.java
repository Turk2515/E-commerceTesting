package stepDefinitions;

import classPages.SelectCategoriesPage;
import hooksClass.HooksClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectCategories {
    WebDriver driver = null;
    SelectCategoriesPage category = new SelectCategoriesPage();
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


}
