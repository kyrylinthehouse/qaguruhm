package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static guru.qa.pages.RegistrationPage.*;

import static guru.qa.tests.TestData.*;



public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName).
                typeLastName(lastName);

        setEmail(userEmail);

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
