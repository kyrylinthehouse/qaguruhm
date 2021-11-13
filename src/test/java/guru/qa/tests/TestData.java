package guru.qa.tests;


import static guru.qa.pages.RegistrationPage.*;

public class TestData {

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static String uploadPicture = "denis.jpg";
    public static String userEmail = faker.internet().emailAddress();
    public static String month = randomMonth();
    public static String year = Integer.toString(faker.number().numberBetween(1970, 2020));
    public static String day = Integer.toString(faker.number().numberBetween(1, 28));
    public static String subject = randomSubjectValue();
    public static String hobbies = randomHobbiesValue();
    public static String currentAddress = faker.address().fullAddress();
    public static String gender = randomGenderValue();
}
