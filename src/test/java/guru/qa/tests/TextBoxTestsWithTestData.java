package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        String firstName = "Denis";
        String lastName = "Rodman";
        String userEmail = "denis.rodman@gmail.com";
        String phoneNumber = "1233211232";
        String uploadPicture = "denis.jpg";
        String month = "April";
        String year = "1972";
        String day = "25";
        String subject = "English";
        String hobbies = "Sports";
        String gender = "Male";
        String currentAddress = "Chicago Bulls center";
        String state = "NCR";
        String city = "Delhi";


        registrationPage.typeFirstName(firstName).
                typeLastName(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $(byText(gender)).click();
        $("[id=userNumber]").setValue(phoneNumber);

        //Date of Birth section
        registrationPage.calendar.setDate(day, month, year);

        //Subject
        $("#subjectsInput").scrollTo().setValue(subject).pressEnter();
        $(byText(hobbies)).click();

        //Picture to select
        $(By.xpath("//input[@id='uploadPicture']")).uploadFromClasspath(uploadPicture);
        //$(By.xpath("//input[@id='uploadPicture']")).uploadFile(new File("src\\test\\java\\resources\\denis.jpg"));

        $("#currentAddress").setValue(currentAddress);

        //State and city section
        $(byText("Select State")).scrollTo().click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();

        $("#submit").click();

        // Tests
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationPage.validation("Student Name", firstName).
                validation("Student Email", userEmail).
                validation("Gender", gender).
                validation("Mobile", phoneNumber).
                validation("Date of Birth", day + " " + month + "," + year).
                validation("Subjects", subject).
                validation("Hobbies", hobbies).
                validation("Picture", uploadPicture).
                validation("Address", currentAddress).
                validation("State and City", state + " " + city);

    }


}
