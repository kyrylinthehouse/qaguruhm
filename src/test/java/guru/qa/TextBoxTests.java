package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String firstName = "Denis";
        String lastName = "Rodman";
        String userEmail = "denis.rodman@gmail.com";
        String phoneNumber = "1233211232";
        String uploadPicture = "denis";
        String month = "April";
        String year = "1972";
        String day = "25";
        String subject = "English";
        String hobbies = "Sports";
        String gender = "Male";
        String currentAddress = "Chicago Bulls center";
        String state = "NCR";
        String city = "Delhi";

        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $(byText(gender)).click();
        $("[id=userNumber]").setValue(phoneNumber);
        //Date of Birth section
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day").find(Condition.text(day)).click();

        //Subject
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobbies)).click();

        //Picture to select
        $(By.xpath("//input[@id='uploadPicture']")).uploadFile(new File("src\\test\\java\\resources\\denis.jpg"));

        $("#currentAddress").setValue(currentAddress);

        //State and city section
        $(By.xpath("//*[contains(text(),'Select State')]")).click();
        $(byText(state)).click();
        $(By.xpath("//*[contains(text(),'Select City')]")).click();
        $(byText(city)).click();

        $("#submit").click();

        // Tests
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        validation("Student Name",firstName);
        validation("Student Email",userEmail);
        validation("Gender",gender);
        validation("Mobile",phoneNumber);
        validation("Date of Birth",day + " " + month + "," + year);
        validation("Subjects",subject);
        validation("Hobbies",hobbies);
        validation("Picture",uploadPicture);
        validation("Address",currentAddress);
        validation("State and City",state + " " + city);

    }

    void validation(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
    }

}
