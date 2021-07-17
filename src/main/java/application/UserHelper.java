package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd){
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//*[.='LOGIN']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@placeholder='Email']"), "12345@asd.com");
        type(By.xpath("//input[@placeholder='Password']"), "aA1234567$");
    }

    public void submitLogin() {
        click(By.xpath("//button[text()=' Login']"));
    }

    public String getTextOfCheckElement() {
        return getText(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void logOut() {
        click(By.xpath("//button[.='Sign Out']"));
    }
}
