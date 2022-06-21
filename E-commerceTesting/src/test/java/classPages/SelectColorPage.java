package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectColorPage {
    public WebElement colorById(WebDriver driver, String id){
        return driver.findElement(By.id(id));
    }
    public WebElement colorByCssSelector(WebDriver driver,String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public WebElement colorByXPath(WebDriver driver,String xPath){
        return driver.findElement(By.xpath(xPath));
    }
}
