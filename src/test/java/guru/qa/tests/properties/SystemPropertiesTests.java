package guru.qa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("properties")
    void someTest4() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
    }

}
