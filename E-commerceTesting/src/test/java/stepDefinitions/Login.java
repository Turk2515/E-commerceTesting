package stepDefinitions;

import classPages.LoginPage;
import hooksClass.HooksClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Login {
    private String email = "email";
    private String password = "password";
    WebDriver driver = null;
    LoginPage login =null;
    SoftAssert soft = null;

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


    @Given("go to website")
    public void go_to_website() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        Thread.sleep(2000);
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(2000);
        throw new io.cucumber.java.PendingException();
    }


    @When("enter email to login")
    public void enter_email_to_login() {
        login.loginById(driver,"Email").click();
        login.loginById(driver,"Email").sendKeys(email);
        throw new io.cucumber.java.PendingException();
    }
    @When("enter password to login")
    public void enter_password_to_login() {
        login.loginById(driver,"Password").click();
        login.loginById(driver,"Password").sendKeys(password);
        throw new io.cucumber.java.PendingException();
    }
    @When("press login")
    public void press_login() throws InterruptedException {
        login.loginById(driver,"RememberMe").click();
        login.loginByCssSelector(driver,"button[type=\"submit\"").click();
        Thread.sleep(2000);
        throw new io.cucumber.java.PendingException();
    }
    @Then("test validation of login")
    public void test_validation_of_login() throws InterruptedException {
        String actualResult1 = login.loginById(driver,"Email-error").getText();
        String expectedResult1 = "Wrong email";
        String actualResult2 = login.loginByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]").getText();
        String expectedResult2 = "Login was unsuccessful. Please correct the errors and try again.";
        soft.assertNotEquals(actualResult1,expectedResult1);
        soft.assertNotEquals(actualResult2,expectedResult2);
        Thread.sleep(4000);
        throw new io.cucumber.java.PendingException();
    }
}
