package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage {
    public WebElement resetById(WebDriver driver, String id){
        return driver.findElement(By.id(id));
    }
    public WebElement resetByCssSelector(WebDriver driver,String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }
    public WebElement resetByXPath(WebDriver driver,String xPath){
        return driver.findElement(By.xpath(xPath));
    }
}
