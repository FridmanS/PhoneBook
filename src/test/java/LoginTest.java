import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void LoginTestPositive(){
        click(By.xpath("//*[.='LOGIN']"));
        type(By.xpath("//input[@placeholder='Email']"), "12345@asd.com");
        type(By.xpath("//input[@placeholder='Password']"), "aA1234567$");
        click(By.xpath("//button[text()=' Login']"));
        Assert.assertEquals(getText(By.xpath("//button[text()='Sign Out']")), "Sign Out");
    }
}
