package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{
    public boolean isContactAdded(String phone){
        List<WebElement> contacts = wd.findElements(By.xpath("//h3"));
        for(WebElement el : contacts){
            if(el.getText().contains(phone)){
                System.out.println(el.getText());
                return true;
            }
        }
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void openFormContact() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void saveContact() {
        click(By.xpath("//button/b"));
    }

    public void fillFormContact(Contact c) {
        type(By.cssSelector("[placeholder='Name']"), c.getName());
        type(By.cssSelector("[placeholder='Last Name']"), c.getLastName());
        type(By.cssSelector("[placeholder='email']"), c.getEmail());
        type(By.cssSelector("[placeholder='Address']"), c.getAddress());
        type(By.cssSelector("[placeholder='description']"), c.getDescription());
    }

    public void removeOneContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }
}
