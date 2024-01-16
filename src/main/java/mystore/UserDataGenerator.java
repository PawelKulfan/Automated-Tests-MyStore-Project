package mystore;

import java.util.Random;

public class UserDataGenerator {
    static Random generator = new Random();//random Object
    static int randomNumber;

    public static int getRandomInt () {
        randomNumber = generator.nextInt(20000) + 10001;//Generator for random int used in emails and password
        return randomNumber;
    }

    static String getFirstName () {
        String[] firstNameArr = {"Paweł", "Andrzej", "Marcin", "Jan", "Jacek"};
        int randomIndexFirstName = generator.nextInt(firstNameArr.length - 1);//Generator for creating random index value for first name arr (bounded by arr length)
        String firstName = firstNameArr[randomIndexFirstName];//Acquring first name from arr using random index generator
        return firstName;
    }
    static String getLastName () {
        String[] lastNameArr = {"Nowak", "Strzeliński", "Barciś", "Kowalski", "Pryczek"};//Arr with last names
        int randomIndexLastName = generator.nextInt(lastNameArr.length - 1);//Generator for creating random index value for last name arr (boumded by arr length)
        String lastName = lastNameArr[randomIndexLastName];//Acquring last name from arr using random index generator
        return lastName;
        }
    static String getEmail () {
        String email = getRandomInt() + "@mejl.com";//Creating user email with random generator
        return email;
    }
    static String getPassword () {
        String password = String.valueOf(randomNumber);//Creating password with random generator - pass same as username
        return password;
    }
    static String getAdress () {
        String[] adressesArr = {"Strużańska 14", "Mickiewicza 1", "Słowackiego 12", "Kuklińskiego 23/78", "Maklakiewicza 235"};//arr with adresses
        int randomIndexAdress = generator.nextInt(adressesArr.length - 1);//Generator for creating random index value for adresses arr (boumded by arr length)
        String adress = adressesArr[randomIndexAdress];//Acquring adress from arr using random index generator
        return adress;
    }
    static String getCity () {
        String[] citiesArr = {"Warszawa", "Kielce", "Poznań", "Węgorzewo", "Chicago"};//arr with cities
        int randomIndexCity = generator.nextInt(citiesArr.length - 1);//Generator for creating random index value for cities arr (boumded by arr length)
        String city = citiesArr[randomIndexCity];//Acquring city from arr using random index generator
        return city;
    }
    static String getPostCode () {
        String[] zipArr = {"3213123", "31-313", "4131123", "32-231", "56-985"};//arr with postal codes
        int randomIndexZip = generator.nextInt(zipArr.length - 1);//Generator for creating random index value for cities arr (boumded by arr length)
        String zip = zipArr[randomIndexZip];//Acquring postal from arr using random index generator
        return zip;
    }
}
