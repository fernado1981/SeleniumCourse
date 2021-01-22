package hook;

import com.github.javafaker.Faker;

public class DataFactory {

    public static Faker faker = new Faker();

    public static String getFirstname(){
        String firstname = faker.name().firstName();
        return firstname;
    }

    public static String getLasttname(){
        String lastname = faker.name().lastName();
        return lastname;
    }

    public static String getEmail(){
        String Email = faker.internet().emailAddress();
        return Email;
    }

    public static String getPhone(){
        String phone = faker.phoneNumber().cellPhone();
        return phone;
    }
}
