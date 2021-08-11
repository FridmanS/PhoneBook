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

    @Test(invocationCount = 10)
    public void addContactTestBase(){
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Contact")
                .lastName("Add")
                .email("add" + i + "@mail.com")
                .phone("0" + i)
                .address("Haifa")
                .description("friend")
                .build();
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactPresent(contact.getPhone()));
    }
    @Test(dataProvider = "dataContactCSV", dataProviderClass = MyDataProvider.class)
    public void addContactTestCSV(Contact contact){
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(contact);
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactPresent(contact.getPhone()));
    }
    @Test(dataProvider = "dataContact", dataProviderClass = MyDataProvider.class)
    public void addContactTest(String name, String lname, String phone, String email, String address, String discription) {
        app.contactHelper().openFormContact();
        app.contactHelper().fillFormContact(Contact.builder()
                .name(name)
                .lastName(lname)
                .phone(phone + (System.currentTimeMillis()/1000)%3600)
                .email(email + (System.currentTimeMillis()/1000)%3600)
                .address(address)
                .description(discription)
                .build());
        app.contactHelper().saveContact();
        Assert.assertTrue(app.contactHelper().isContactPresent(phone));
    }
}
