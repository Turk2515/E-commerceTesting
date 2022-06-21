package stepDefinitions;

import classPages.LoginPage;
import classPages.ResetPasswordPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ResetPassword {
    private String email = "email";
    private String password = "password";
    private String oldPassword = "old password";
    private String newPassword = "new password";
    private String confirmNewPassword = "confirm new password";
    WebDriver driver = null;
    ResetPasswordPage reset =new ResetPasswordPage();
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
        reset.resetById(driver,"Email").click();
        reset.resetById(driver,"Email").sendKeys(email);
    }


    @And("^enter password to login$")
    public void enterPassword(){
        reset.resetById(driver,"Password").click();
        reset.resetById(driver,"Password").sendKeys(password);
    }


    @And("^press login$")
    public void pressRememberMe() throws InterruptedException {
        reset.resetById(driver,"RememberMe").click();
        reset.resetByCssSelector(driver,"button[type=\"submit\"").click();
        Thread.sleep(2000);
    }

    @And("^go to my account$")
    public void myAccount() throws InterruptedException {
        reset.resetByXPath(driver,"/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a").click();
        Thread.sleep(2000);
        reset.resetByCssSelector(driver,"a[href=\"/customer/changepassword\"").click();
        Thread.sleep(2000);
    }


    @And("^change password$")
    public void changePassword(){
        reset.resetById(driver,"OldPassword").click();
        reset.resetById(driver,"OldPassword").sendKeys(oldPassword);

        reset.resetById(driver,"NewPassword").click();
        reset.resetById(driver,"NewPassword").sendKeys(newPassword);

        reset.resetById(driver,"ConfirmNewPassword").click();
        reset.resetById(driver,"ConfirmNewPassword").sendKeys(confirmNewPassword);

        reset.resetById(driver,"ConfirmNewPassword").sendKeys(Keys.ENTER);
    }

    @Then("^ensure password is changed$")
    public void isPasswordChanged(){
        String actualResult = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
        String expectedResult = "Password was changed";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @After
    public void closeSite(){
        driver.quit();
    }
}
