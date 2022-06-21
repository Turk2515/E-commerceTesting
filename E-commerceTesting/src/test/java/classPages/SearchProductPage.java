package classPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class SearchProductPage {
    public WebElement searchById(WebDriver driver,String id){
        return driver.findElement(By.id(id));
    }
}
