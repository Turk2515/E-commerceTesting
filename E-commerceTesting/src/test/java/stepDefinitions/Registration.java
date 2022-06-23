package stepDefinitions;

import classPages.LoginPage;
import classPages.RegistrationPage;
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

public class Registration {
    public static WebDriver driver;
    RegistrationPage register = new RegistrationPage();
    @Before
    public void site_setup(){
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver =new ChromeDriver();

    }
    @Given("^open the site$")
    public void open_the_site() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/"); // go to website
        driver.manage().window().maximize(); // fullscreen
        Thread.sleep(2000);
        driver.findElement(By.className("ico-register")).click();
        Thread.sleep(2000);
    }

    @When("^enter gender$")
    public void chooseGender() throws InterruptedException {
        register.registrationById(driver,"gender-male").click();
        Thread.sleep(1000);
    }


    @When("^enter valid first name$")
    public void enterFName() throws InterruptedException {
        register.registrationById(driver,"FirstName").click();
        register.registrationById(driver,"FirstName").sendKeys("Mostafa");
        Thread.sleep(1000);
    }


    @And("^enter valid last name$")
    public void enterLName() throws InterruptedException {
        register.registrationById(driver,"LastName").click();
        register.registrationById(driver,"LastName").sendKeys("Maher");
        Thread.sleep(1000);
    }


    @And("^enter Birthday date$")
    public void enterBirthdayDate() throws InterruptedException {
        register.registrationByCssSelector(driver,"select[name=\"DateOfBirthDay\"]").click();
        register.registrationByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[22]").click();
        Thread.sleep(1000);
        register.registrationByCssSelector(driver,"select[name=\"DateOfBirthMonth\"]").click();
        register.registrationByXPath(driver,"/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[4]").click();
        Thread.sleep(1000);
        register.registrationByCssSelector(driver,"select[name=\"DateOfBirthYear\"]").click();
        register.registrationByCssSelector(driver,"option[value=\"1999\"]").click();
        Thread.sleep(1000);
    }


    @And("^enter email to register$")
    public void enterEmail() throws InterruptedException {
        register.registrationById(driver,"Email").click();
        register.registrationById(driver,"Email").sendKeys("mostafamaher2515@gmail.com");
        Thread.sleep(1000);
    }


    @And("^enter company name$")
    public void companyName() throws InterruptedException {
        register.registrationById(driver,"Company").click();
        register.registrationById(driver,"Company").sendKeys("Microsoft");
        Thread.sleep(1000);
    }
    @And("^enter password to register$")
    public void enterPassword() throws InterruptedException {
        register.registrationById(driver,"Password").click();
        register.registrationById(driver,"Password").sendKeys("password");
        Thread.sleep(1000);
    }
    @And("^confirm password$")
    public void confirmPassword() throws InterruptedException {
        register.registrationById(driver,"ConfirmPassword").click();
        register.registrationById(driver,"ConfirmPassword").sendKeys("password");
        Thread.sleep(1000);
    }
    @Then("^confirm data$")
    public void confirmData() throws InterruptedException {
        register.registrationById(driver,"register-button").click();
        Thread.sleep(1000);
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),"Test pass");
        Thread.sleep(20000);
    }

    @After
    public void closeSite(){
        driver.quit();
    }


}
