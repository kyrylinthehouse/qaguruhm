package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static guru.qa.pages.RegistrationPage.*;

import static guru.qa.tests.TestData.*;
import static io.qameta.allure.Allure.step;


public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage();

        registrationPage.typeFirstName(firstName).
                typeLastName(lastName);

        step("enter email", () -> {
            setEmail(userEmail);
        });



        setGender(gender);

        setPhoneNumber(phoneNumber);

        //Date of Birth section
        registrationPage.calendar.setDate(day, month, year);

        //Subject
        setSubject(subject);

        setHobbies(hobbies);

        //Picture to select
        uploadPicture(uploadPicture);

        setAddress(currentAddress);

        stateAndCity();

        submitForm();


        // Tests
        registrationPage.validation("Student Name", firstName).
                validation("Student Email", userEmail).
                validation("Gender", gender).
                validation("Mobile", phoneNumber).
                validation("Date of Birth", day + " " + month + "," + year).
                validation("Subjects", subject).
                validation("Hobbies", hobbies).
                validation("Picture", uploadPicture).
                validation("Address", currentAddress);

    }

}
