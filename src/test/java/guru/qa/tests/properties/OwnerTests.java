package guru.qa.tests.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

        public static String getSelenide(){
            return format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", credentials.login(), credentials.password());
        }







        
}
