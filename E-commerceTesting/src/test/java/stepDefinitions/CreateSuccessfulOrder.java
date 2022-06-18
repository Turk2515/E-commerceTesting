package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateSuccessfulOrder {

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


    @And("^press on add to cart$")
    public void pressOnAddToCart(){
        driver.findElement(By.id("add-to-cart-button-25")).click();
    }

    @And("^go to cart$")
    public void goToCart() throws InterruptedException {
        driver.findElement(By.id("topcartlink")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

    }

    @And("^enter billing address$")
    public void enterBillingAddress(){
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]/option[66]")).click();
        driver.findElement(By.xpath("BillingNewAddress_City")).sendKeys("Giza");
        driver.findElement(By.xpath("BillingNewAddress_Address1")).sendKeys("Giza");
        driver.findElement(By.xpath("BillingNewAddress_ZipPostalCode")).sendKeys("12111");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();
    }

}
