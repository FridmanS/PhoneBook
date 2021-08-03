import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.userHelper().isLogged()){
            app.userHelper().logOut();
        }
    }

    @Test
    public void LoginTestPositive(){
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("12345@asd.com", "aA1234567$");
        app.userHelper().submitLogin();
        Assert.assertEquals(app.userHelper().getTextOfCheckElement(), "Sign Out");
        logger.info("Test passed");
    }

    @Test
    public void loginTestWithWrongPassword(){
        User user = new User().withEmail("12345@asd.com").withPassword("aA1234567");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        logger.info(String.format("Login with Email: %s; Password: %s;", user.getEmail(), user.getPassword()));
        app.userHelper().submitLogin();
        app.userHelper().acceptAlert();
        Assert.assertFalse(app.userHelper().isLogged());
        logger.info("Test passed");
    }
}
