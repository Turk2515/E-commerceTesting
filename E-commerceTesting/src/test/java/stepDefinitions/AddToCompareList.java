package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddToCompareList {
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

    @When("^press on search bar")
    public void pressOnSearchBar() throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).click();
        driver.findElement(By.id("small-searchterms")).sendKeys("adidas");
        driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @And("^select product and color")
    public void selectProduct() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/adidas-consortium-campus-80s-running-shoes\"")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"color-squares-10\"]/li[2]/label/span/span")).click();
    }

    @And("^select size$")
    public void selectSize(){
        driver.findElement(By.id("product_attribute_9")).click();
        driver.findElement(By.xpath("//*[@id=\"product_attribute_9\"]/option[4]")).click();
    }

    @And("^press on add to compare list")
    public void pressOnAddToCompareList(){
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[2]/button")).click();
    }

    @Then("^ensure the product is added to compare list")
    public void isAddedToCompareList() throws InterruptedException {
        String actualResult = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/text()")).getText();
        String expectedResult = "The product has been added to your ";
        Assert.assertEquals(actualResult,expectedResult);
        Thread.sleep(2000);
        driver.quit();
    }
}
