package guru.qa.utils;

import java.util.Date;
import java.util.Random;
import com.github.javafaker.Faker;

public class RandomUtils {

    public static String getRandomString(int lenght) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < lenght) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

}
