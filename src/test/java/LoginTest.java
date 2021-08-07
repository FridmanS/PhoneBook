import application.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @DataProvider
    public Iterator<Object[]> validDataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"12345@asd.com", "aA1234567$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com", "Ss12345$"});
        return list.iterator();
    }

    @Test(dataProvider = "validDataLogin")
    public void loginTestDataProvider(String email, String password) {
        User user = new User()
                .withEmail(email).withPassword(password);
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        logger.info(String.format("Login with Email: %s; Password: %s;"
                , user.getEmail(), user.getPassword()));
        app.userHelper().submitLogin();
        Assert.assertTrue(app.userHelper().isLogged());
        logger.info("Test passed");
    }

    @Test(dataProvider = "validLoginDataClassDP", dataProviderClass = MyDataProvider.class)
    public void loginTestDataProviderClass(String email, String password) {
        User user = new User()
                .withEmail(email).withPassword(password);
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        logger.info(String.format("Login with Email: %s; Password: %s;"
                , user.getEmail(), user.getPassword()));
        app.userHelper().submitLogin();
        Assert.assertTrue(app.userHelper().isLogged());
        logger.info("Test passed");
    }

    @Test(dataProvider = "dataFileCSV", dataProviderClass = MyDataProvider.class)
    public void loginTestDP_CSV(User user) {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        logger.info(String.format("Login with Email: %s; Password: %s;"
                , user.getEmail(), user.getPassword()));
        app.userHelper().submitLogin();
        Assert.assertTrue(app.userHelper().isLogged());
        logger.info("Test passed");
    }

}
