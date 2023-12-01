package Polyaeva;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;


import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

@Testable
public class PhoneBookTest {
    private static PhoneBook phoneBook;

    @BeforeEach
    public void setup() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void addGroupTest() {
        String groupName = "Friends";
        boolean result = true;
        assertThat(phoneBook.addGroup(groupName), equalTo(result));
    }

    @AfterEach
    public void tearDown() {
        phoneBook = null;
    }

    @Test
    public void findContactInGroupTest() {
        String groupName = "Friends";
        String name = "Liubov";

        Contact contact = phoneBook.findContactInGroup(name, groupName);

        assertThat(contact, nullValue());
    }

    @Test
    public void addContactInGroupTest() {
        Contact contact = new Contact("Liubov", "89183380985");
        String groupName = "Friends";
        assertThat(phoneBook.addContactInGroup(contact, groupName),equalTo(true));
    }

    @Test
    public void findUsePhoneNumberTest() {
        Contact contact = phoneBook.findUsePhoneNumber("89183380985");
        assertThat(contact, nullValue());
    }

    @Test
    public void getGroupNameTest() {
        Set<String> groupName = phoneBook.getGroupName();
        assertThat(groupName.size(), equalTo(0));
    }


}
