package stepDefinitions;

import classPages.ChangeCurrencyPage;
import hooksClass.HooksClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChangeCurrency {
    ChangeCurrencyPage currency = new ChangeCurrencyPage();
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
    @When("^change currency$")
    public void changeCurrency(){
        currency.changeCurrencyById(driver,"customerCurrency").click();
        currency.changeCurrencyByXPath(driver,"//*[@id=\"customerCurrency\"]/option[2]").click();
    }


    @Then("^ensure that euro is selected")
    public void ensureThatEuroIsSelected(){
        Boolean actualResult1= currency.changeCurrencyByXPath(driver,"//*[@id=\"customerCurrency\"]/option[2]").isSelected();
        Boolean expectedResult1 = true;
        Assert.assertEquals(actualResult1,expectedResult1);

        String actualResult2 = currency.changeCurrencyByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]/span").getText();
        String expectedResult2 = "€1032.00";
        Assert.assertEquals(actualResult2,expectedResult2);

        String actualResult3 = currency.changeCurrencyByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[1]/span").getText();
        String expectedResult3 = "€1548.00";
        Assert.assertEquals(actualResult3,expectedResult3);

        String actualResult4 = currency.changeCurrencyByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[1]/span").getText();
        String expectedResult4 = "€210.70";
        Assert.assertEquals(actualResult4,expectedResult4);

        String actualResult5 = currency.changeCurrencyByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[4]/div/div[2]/div[3]/div[1]/span").getText();
        String expectedResult5 = "€21.50";
        Assert.assertEquals(actualResult5,expectedResult5);

    }


}
