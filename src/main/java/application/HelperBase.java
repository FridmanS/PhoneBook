package application;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }
    public void click(By locator){

        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        click(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator){

        return wd.findElement(locator).getText();
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }
}
