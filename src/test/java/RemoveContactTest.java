import models.User;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().login(new User().withEmail("12345@asd.com").withPassword("aA1234567$"));
        }
    }

    @Test
    public void removeOneContact(){
        app.contactHelper().removeOneContact();
    }


}
