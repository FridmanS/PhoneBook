package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class ContactHelper extends HelperBase {
    public boolean isContactPresent(String phone) {
        List<WebElement> contacts = wd.findElements(By.xpath("//h3"));
        for (WebElement el : contacts) {
            if (el.getText().contains(phone)) {
                return true;
            }
        }
        return false;
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void openFormContact() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void saveContact() {
        click(By.xpath("//button/b"));
        new WebDriverWait(wd, 5).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div[class^='contact-page']"))));
    }

    public void fillFormContact(Contact c) {
        type(By.cssSelector("[placeholder='Name']"), c.getName());
        type(By.cssSelector("[placeholder='Last Name']"), c.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), c.getPhone());
        type(By.cssSelector("[placeholder='email']"), c.getEmail());
        type(By.cssSelector("[placeholder='Address']"), c.getAddress());
        type(By.cssSelector("[placeholder='description']"), c.getDescription());
    }

    public String removeOneContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        String phone = wd.findElement(By.xpath("//h3")).getText();
        click(By.xpath("//button[.='Remove']"));
        return phone;
    }

    public void removeAllContacts() {
        while(!isElementPresent(By.xpath("//*[.=' No Contacts here!']"))){
            removeOneContact();
        }
    }

    public boolean listOfContactIsEmpty() {
        return isElementPresent(By.xpath("//*[.=' No Contacts here!']"));
    }
}
