package stepDefinitions;

import classPages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Login {

    private String email = "email";
    private String password = "password";
    WebDriver driver = null;
    LoginPage login =null;
    SoftAssert soft = null;
    @Before
    public void openSite() throws InterruptedException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver =new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        Thread.sleep(2000);
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(2000);

    }

    @When("^enter email to login$")
    public void enterEmail(){
        login.loginById(driver,"Email").click();
        login.loginById(driver,"Email").sendKeys(email);
    }


    @And("^enter password to login$")
    public void enterPassword(){
        login.loginById(driver,"Password").click();
        login.loginById(driver,"Password").sendKeys(password);
    }


    @And("^press login$")
    public void pressRememberMe() throws InterruptedException {
        login.loginById(driver,"RememberMe").click();
        login.loginByCssSelector(driver,"button[type=\"submit\"").click();
        Thread.sleep(2000);
    }
    @Then("^test validation of login$")
    public void testValidationOfLogin() throws InterruptedException {
        String actualResult1 = login.loginById(driver,"Email-error").getText();
        String expectedResult1 = "Wrong email";
        String actualResult2 = login.loginByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]").getText();
        String expectedResult2 = "Login was unsuccessful. Please correct the errors and try again.";
        soft.assertNotEquals(actualResult1,expectedResult1);
        soft.assertNotEquals(actualResult2,expectedResult2);
        Thread.sleep(4000);
    }

    @After
    public void closeSite(){
        driver.quit();
    }



}
