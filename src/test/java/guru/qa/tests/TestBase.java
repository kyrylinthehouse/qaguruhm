package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    public static Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x768";
    }
}
