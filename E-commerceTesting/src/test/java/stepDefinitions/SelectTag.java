package stepDefinitions;

import classPages.SelectTagPage;
import hooksClass.HooksClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectTag {
    SelectTagPage tag = new SelectTagPage();
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


}
