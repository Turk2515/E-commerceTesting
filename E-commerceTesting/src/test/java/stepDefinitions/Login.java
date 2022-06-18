package stepDefinitions;

import classPages.IdClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {

    private String email = "email";
    private String password = "Mostafa25";
    WebDriver driver = null;
    IdClass login =null;
    SoftAssert soft = null;
    @Given("^open site to login$")
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
//        login.byId(driver,"Email").click();
//        login.byId(driver,"Email").sendKeys(email);
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
    }


    @And("^enter password to login$")
    public void enterPassword(){
//        login.byId("Password").click();
//        login.byId("Password").sendKeys(password);
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys(password);
    }


    @Then("^press login$")
    public void pressRememberMe() throws InterruptedException {
//        login.byId("RememberMe").click();
//        driver.findElement(By.cssSelector("button[type=\"submit\"")).click();
//        Thread.sleep(2000);
        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.cssSelector("button[type=\"submit\"")).click();
        Thread.sleep(2000);
    }
    @After
    public void testValidationOfLogin() throws InterruptedException {
        String actualResult1 = driver.findElement(By.id("Email-error")).getText();
        String expectedResult1 = "Wrong email";
        String actualResult2 = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();
        String expectedResult2 = "Login was unsuccessful. Please correct the errors and try again.";
        soft.assertNotEquals(actualResult1,expectedResult1);
        soft.assertNotEquals(actualResult2,expectedResult2);
        Thread.sleep(4000);
        driver.quit();
    }



}
