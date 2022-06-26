package stepDefinitions;

import classPages.AddToCompareListPage;
import hooksClass.HooksClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCompareList {
    AddToCompareListPage compare = new AddToCompareListPage();
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
        compare.addToCompareListById(driver,"small-searchterms").click();
        compare.addToCompareListById(driver,"small-searchterms").sendKeys("adidas");
        compare.addToCompareListById(driver,"small-searchterms").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("^select product and color")
    public void selectProduct() throws InterruptedException {
        compare.addToCompareListByCssSelector(driver,"a[href=\"/adidas-consortium-campus-80s-running-shoes\"").click();
        compare.addToCompareListByXPath(driver,"//*[@id=\"color-squares-10\"]/li[2]/label/span/span").click();
        Thread.sleep(2000);
    }

    @And("^select size$")
    public void selectSize(){
        compare.addToCompareListById(driver,"product_attribute_9").click();
        compare.addToCompareListByXPath(driver,"//*[@id=\"product_attribute_9\"]/option[4]").click();
    }

    @And("^press on add to compare list")
    public void pressOnAddToCompareList(){
        compare.addToCompareListByXPath(driver,"//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[2]/button").click();
    }

    @Then("^ensure the product is added to compare list")
    public void isAddedToCompareList() throws InterruptedException {
        String actualResult = compare.addToCompareListByXPath(driver,"//*[@id=\"bar-notification\"]/div/p/text()").getText();
        String expectedResult = "The product has been added to your ";
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(2000);

    }


}
