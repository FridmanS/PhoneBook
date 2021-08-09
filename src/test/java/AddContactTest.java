import application.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().login(new User().withEmail("12345@asd.com").withPassword("aA1234567$"));
        }
    }

    @Test(invocationCount = 3)
    public void addContactTestBase(){
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Contact")
                .lastName("Add")
                .email("add" + i + "@mail.com")
                .phone("" + i)
                .address("Haifa")
                .description("friend")
                .build();
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactAdded(contact.getPhone()));
    }
    @Test(dataProvider = "dataContactCSV", dataProviderClass = MyDataProvider.class)
    public void addContactTestCSV(Contact contact){
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactAdded(contact.getPhone()));
    }
}
