package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangeCurrencyPage {
    public WebElement changeCurrencyById(WebDriver driver, String id){
        return driver.findElement(By.id(id));
    }

    public WebElement changeCurrencyByXPath(WebDriver driver,String xPath){
        return driver.findElement(By.xpath(xPath));
    }
}
