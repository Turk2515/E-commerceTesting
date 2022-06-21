package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectTagPage {
    public WebElement tagByCssSelector(WebDriver driver, String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }
}
