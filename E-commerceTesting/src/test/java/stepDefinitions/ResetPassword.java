package stepDefinitions;

import classPages.IdClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

public class ResetPassword {
    private String email = "email";
    private String password = "password";
    private String oldPassword = "old password";
    private String newPassword = "new password";
    private String confirmNewPassword = "confirm new password";
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


    @And("^press login$")
    public void pressRememberMe() throws InterruptedException {
//        login.byId("RememberMe").click();
//        driver.findElement(By.cssSelector("button[type=\"submit\"")).click();
//        Thread.sleep(2000);
        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.cssSelector("button[type=\"submit\"")).click();
        Thread.sleep(2000);
    }

    @And("^go to my account$")
    public void myAccount() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href=\"/customer/changepassword\"")).click();
        Thread.sleep(2000);
    }


    @And("^change password$")
    public void changePassword(){
        driver.findElement(By.id("OldPassword")).click();
        driver.findElement(By.id("OldPassword")).sendKeys(oldPassword);

        driver.findElement(By.id("NewPassword")).click();
        driver.findElement(By.id("NewPassword")).sendKeys(newPassword);

        driver.findElement(By.id("ConfirmNewPassword")).click();
        driver.findElement(By.id("ConfirmNewPassword")).sendKeys(confirmNewPassword);

        driver.findElement(By.id("ConfirmNewPassword")).sendKeys(Keys.ENTER);
    }

    @Then("^ensure password is changed$")
    public void isPasswordChanged(){
        String actualResult = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
        String expectedResult = "Password was changed";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
