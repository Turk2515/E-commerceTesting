package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectCategoriesPage {
    public WebElement categoryByCssSelector(WebDriver driver, String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }
    public WebElement categoryByXPath(WebDriver driver,String xPath){
        return driver.findElement(By.xpath(xPath));
    }
}
