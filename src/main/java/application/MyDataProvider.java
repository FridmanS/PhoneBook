package application;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validLoginDataClassDP(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"12345@asd.com", "aA1234567$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com", "Ss12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataFileCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> dataContactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contactsData.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2] + (System.currentTimeMillis()/1000)%3600)
                    .email(split[3] + (System.currentTimeMillis()/1000)%3600)
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> dataContact() throws IOException {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"erty", "erty", "3456", "dghhgf", "dfghgfh", "dgfhfgh"});
        list.add(new Object[]{"ertyasdf", "asdfasdf", "3452346", "dghasdfhgf", "dfghasdfgfh", "dgfdfghfgh"});
        list.add(new Object[]{"ertrgherty", "eghfdgh", "345236", "ghfnb", "yuoiui", "dgfhftyutyugh"});
        list.add(new Object[]{"cxvb", "tryjtrj", "6789", "dghsdghsgdhgf", "dfghggfhdfghfh", "dgfdfghdfhfgh"});

        return list.iterator();
    }
}
