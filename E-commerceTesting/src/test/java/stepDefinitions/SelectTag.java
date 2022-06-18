package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectTag {
    WebDriver driver = null;
    @Given("^open site$")
    public void openSite() throws InterruptedException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver =new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        Thread.sleep(2000);
    }

    @When("^press on category$")
    public void pressOnCategory() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/apparel\"")).click();
        Thread.sleep(2000);
    }
    @And("^select a tag$")
    public void selectTag() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/awesome\"")).click();
        Thread.sleep(2000);
    }

    @Then("^ensure a tag is selected")
    public void isTagSelected(){

    }
}
