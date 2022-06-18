package stepDefinitions;

import classPages.IdClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Registration {
    public static WebDriver driver;
    IdClass regist = null;
    @Given("^open browser to register$")
    public void openSite() throws InterruptedException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver =new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        Thread.sleep(2000);
        driver.findElement(By.className("ico-register")).click();
        Thread.sleep(2000);
    }


    @When("^enter gender$")
    public void chooseGender() throws InterruptedException {
        regist.byId("gender-male").click();
        Thread.sleep(1000);
    }


    @When("^enter valid first name$")
    public void enterFName() throws InterruptedException {
        regist.byId("FirstName").click();
        regist.byId("FirstName").sendKeys("Mostafa");
        Thread.sleep(1000);
    }


    @And("^enter valid last name$")
    public void enterLName() throws InterruptedException {
        regist.byId("LastName").click();
        regist.byId("LastName").sendKeys("Maher");
        Thread.sleep(1000);
    }


    @And("^enter Birthday date$")
    public void enterBirthdayDate() throws InterruptedException {
        driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[22]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")).click();
        driver.findElement(By.cssSelector("option[value=\"1999\"]")).click();
        Thread.sleep(1000);
    }


    @And("^enter email to register$")
    public void enterEmail() throws InterruptedException {
        regist.byId("Email").click();
        regist.byId("Email").sendKeys("mostafamaher2515@gmail.com");
        Thread.sleep(1000);
    }


    @And("^enter company name$")
    public void companyName() throws InterruptedException {
        regist.byId("Company").click();
        regist.byId("Company").sendKeys("Microsoft");
        Thread.sleep(1000);
    }
    @And("^enter password to register$")
    public void enterPassword() throws InterruptedException {
        regist.byId("Password").click();
        regist.byId("Password").sendKeys("Mostafa25");
        Thread.sleep(1000);
    }
    @And("^confirm password$")
    public void confirmPassword() throws InterruptedException {
        regist.byId("ConfirmPassword").click();
        regist.byId("ConfirmPassword").sendKeys("Mostafa25");
        Thread.sleep(1000);
    }
    @Then("^confirm data$")
    public void confirmData() throws InterruptedException {
        regist.byId("register-button").click();
        Thread.sleep(1000);
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actualResult.contains(expectedResult),"Test pass");
        Thread.sleep(20000);
        driver.quit();
    }




}
