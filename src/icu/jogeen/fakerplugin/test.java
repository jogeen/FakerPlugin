package icu.jogeen.fakerplugin;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * @Author jogeen
 * @Date 9:40 2021/1/19
 * @Version v1.0
 * @Description
 */
public class test {
    public static void main(String[] args) {
        Faker faker = new Faker(Locale.SIMPLIFIED_CHINESE);
        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton
        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println(faker.animal().name());
        System.out.println(faker.color().name());
        System.out.println(name);
        System.out.println(lastName);
        System.out.println(firstName);
        System.out.println();
    }

}
