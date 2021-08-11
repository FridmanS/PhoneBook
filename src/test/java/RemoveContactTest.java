import models.User;
import org.testng.Assert;
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
        if(!app.contactHelper().listOfContactIsEmpty()) {
            String phone = app.contactHelper().removeOneContact();
            Assert.assertFalse(app.contactHelper().isContactPresent(phone));
        }else
            logger.info("List of contacts is empty");
    }

    @Test
    public void removeAllContacts(){
        if(!app.contactHelper().listOfContactIsEmpty()) {
            app.contactHelper().removeAllContacts();
            Assert.assertTrue(app.contactHelper().listOfContactIsEmpty());
        }else
            logger.info("List of contacts is empty");
    }
}
