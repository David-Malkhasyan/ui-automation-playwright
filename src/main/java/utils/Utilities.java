package utils;

import com.github.javafaker.Faker;

public class Utilities {
    static Faker faker = new Faker();

    public static String generateUsername() {
        return faker.name().name();
    }

    public static String generatePassword() {
        return faker.name().username();
    }

}
