package employee_productivity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactInfoTest {

  private ContactInfo contactInfo;
  private Name name;
  private Name emergencyContactName;

  @BeforeEach
  void setUp() {
    name = new Name("Samantha", "Lee");
    emergencyContactName = new Name("Michael", "Chang");
    contactInfo = new ContactInfo(name, "456 Elm St", "555-5678", "samantha.lee@example.com", emergencyContactName);
  }

  @Test
  void getName() {
    assertEquals(name, contactInfo.getName());
  }

  @Test
  void setName() {
    Name newName = new Name("Olivia", "Kim");
    contactInfo.setName(newName);
    assertEquals(newName, contactInfo.getName());
  }

  @Test
  void getAddress() {
    assertEquals("456 Elm St", contactInfo.getAddress());
  }

  @Test
  void setAddress() {
    String newAddress = "789 Maple Ave";
    contactInfo.setAddress(newAddress);
    assertEquals(newAddress, contactInfo.getAddress());
  }

  @Test
  void getPhoneNumber() {
    assertEquals("555-5678", contactInfo.getPhoneNumber());
  }

  @Test
  void setPhoneNumber() {
    String newPhoneNumber = "555-9876";
    contactInfo.setPhoneNumber(newPhoneNumber);
    assertEquals(newPhoneNumber, contactInfo.getPhoneNumber());
  }

  @Test
  void getEmailAddress() {
    assertEquals("samantha.lee@example.com", contactInfo.getEmailAddress());
  }

  @Test
  void setEmailAddress() {
    String newEmailAddress = "olivia.kim@example.com";
    contactInfo.setEmailAddress(newEmailAddress);
    assertEquals(newEmailAddress, contactInfo.getEmailAddress());
  }

  @Test
  void getEmergencyContactName() {
    assertEquals(emergencyContactName, contactInfo.getEmergencyContactName());
  }

  @Test
  void setEmergencyContactName() {
    Name newEmergencyContactName = new Name("David", "Nguyen");
    contactInfo.setEmergencyContactName(newEmergencyContactName);
    assertEquals(newEmergencyContactName, contactInfo.getEmergencyContactName());
  }

  @Test
  void testToString() {
    String expectedString = "ContactInfo{name=" + name + ", address='456 Elm St', phoneNumber='555-5678', emailAddress='samantha.lee@example.com', emergencyContactName=" + emergencyContactName + "}";
    assertEquals(expectedString, contactInfo.toString());
  }

  @Test
  void testEquals() {
    ContactInfo sameContactInfo = new ContactInfo(name, "456 Elm St", "555-5678", "samantha.lee@example.com", emergencyContactName);
    ContactInfo differentContactInfo = new ContactInfo(new Name("Olivia", "Kim"), "789 Maple Ave", "555-9876", "olivia.kim@example.com", new Name("David", "Nguyen"));
    assertEquals(contactInfo, sameContactInfo);
    assertNotEquals(contactInfo, differentContactInfo);
  }

  @Test
  void testHashCode() {
    ContactInfo sameContactInfo = new ContactInfo(name, "456 Elm St", "555-5678", "samantha.lee@example.com", emergencyContactName);
    assertEquals(contactInfo.hashCode(), sameContactInfo.hashCode());
  }
}
