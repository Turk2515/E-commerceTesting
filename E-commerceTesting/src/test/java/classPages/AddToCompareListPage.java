package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCompareListPage {
    public WebElement addToCompareListById(WebDriver driver, String id){
        return driver.findElement(By.id(id));
    }
    public WebElement addToCompareListByCssSelector(WebDriver driver,String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public WebElement addToCompareListByXPath(WebDriver driver,String xPath){
        return driver.findElement(By.xpath(xPath));
    }
}
