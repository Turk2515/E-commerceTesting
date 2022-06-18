package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdClass {
    WebDriver driver=null;
    public <driver> WebElement byId(String id){
        return driver.findElement(By.id(id));
    }
}
