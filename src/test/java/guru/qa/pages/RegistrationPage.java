package guru.qa.pages;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import guru.qa.pages.components.CalendarComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;


public class RegistrationPage {
    public static Faker faker = new Faker();
    public CalendarComponent calendar = new CalendarComponent();
    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            fromTittle = $(".practice-form-wrapper"),
            firstNameInput = $("[id=firstName]"),
            firstLastInput = $("[id=lastName]"),
            resultsTable = $(".table-responsive");

    // actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        fromTittle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public void typeLastName(String value) {
        firstLastInput.setValue(value);
    }

    public RegistrationPage validation(String label, String value) {
        resultsTable.$(byText(label)).parent().shouldHave(text(value));

        return this;
    }

    public static String randomMonth() {
        int Min = 0;
        int Max = 11;
        int month = (Min + (int) (Math.random() * (Max - Min)));
        switch (month) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
        }
        return null;
    }

    public static String randomGenderValue() {
        int random = faker.number().numberBetween(0, 2);
        String valueGender = " ";
        switch (random) {
            case 0:
                valueGender = "Male";
                break;
            case 1:
                valueGender = "Female";
                break;
            case 2:
                valueGender = "Other";
                break;
        }
        return valueGender;
    }

    public static void setGender(String gender) {

        $(byText(gender)).click();
    }

    public static String randomSubjectValue() {
        String[] sub = {"Maths", "Arts", "Biology"};
        return sub[faker.random().nextInt(0, 2)];
    }

    public static void setSubject(String subject) {
        $("#subjectsInput").scrollTo().setValue(subject).pressEnter();
    }

    public static String randomHobbiesValue() {
        String[] sub = {"Sports", "Reading", "Music"};
        return sub[faker.random().nextInt(0, 2)];
    }

    public static void setHobbies(String hobbies) {
        $(byText(hobbies)).click();
    }

    public static void stateAndCity() {
        $(byText("Select State")).scrollTo().click();
        String[] arrState = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String state = arrState[faker.random().nextInt(0, 3)];
        $(byText(state)).click();
        $(byText("Select City")).click();
        if (state == "NCR") {
            String[] nrc = {"Delhi", "Gurgaon", "Noida"};
            $(byText(nrc[faker.random().nextInt(0, 2)])).click();
        }
        if (state == "Uttar Pradesh") {
            String[] uttarPradesh = {"Agra", "Lucknow", "Merrut"};
            $(byText(uttarPradesh[faker.random().nextInt(0, 2)])).click();
        }
        if (state == "Haryana") {
            String[] haryana = {"Karnal", "Panipat"};
            $(byText(haryana[faker.random().nextInt(0, 1)])).click();
        }
        if (state == "Rajasthan") {
            String[] rajasthan = {"Jaipur", "Jaiselmer"};
            $(byText(rajasthan[faker.random().nextInt(0, 1)])).click();
        }

    }

    public static void setEmail(String email) {
        $("[id=userEmail]").setValue(email);
    }
    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void setPhoneNumber(String number) {
        $("[id=userNumber]").setValue(number);
    }

    public static void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    public static void uploadPicture(String picture){
        //$(By.xpath("//input[@id='uploadPicture']")).uploadFromClasspath(picture);
        $(By.xpath("//input[@id='uploadPicture']")).uploadFile(new File("src\\test\\resources\\denis.jpg"));
    }

    public static void submitForm(){
        $("#submit").click();
    }
}
