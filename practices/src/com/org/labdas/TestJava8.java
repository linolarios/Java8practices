package com.org.labdas;

import java.lang.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by STO on 05/04/2016.
 */
public class TestJava8 {

public static void main(String args[]){

    Map map = new HashMap<String,Integer>();

    List<Person> list = new ArrayList<>();

    list.add(new Person("Jules",LocalDate.of(2014, Month.JANUARY, 1),Person.Sex.MALE,"jules@j.com"));
    list.add(new Person("George",LocalDate.of(1996, Month.FEBRUARY, 1),Person.Sex.MALE,"geo@j.com"));
    list.add(new Person("Bob",LocalDate.of(1986, Month.MARCH, 1),Person.Sex.MALE,"bob@j.com"));
    list.add(new Person("Anthony",LocalDate.of(1984, Month.APRIL, 1),Person.Sex.MALE,"ant@j.com"));
    list.add(new Person("Mark",LocalDate.of(1970, Month.MAY, 1),Person.Sex.MALE,"mark@j.com"));
    list.add(new Person("Roxanne",LocalDate.of(1988, Month.MAY, 1),Person.Sex.FEMALE,"rox@j.com"));



    System.out.println("Persons between 18 yo and 40 yo");
    printPersonsWithPredicate(
            list,
            p -> p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 40
    );

    System.out.println("Persons who has M in his birthday month");
    printPersonsWithPredicate(
            list,
            p -> p.getBirthday().getMonth().toString().contains("M")

    );

    System.out.println("Persons who has the O consonant in his name");

    printPersonsWithPredicate(
            list,
            p -> p.getName().contains("o")

    );
}

    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }


}


class Person {



    Person(String name,LocalDate birtd,Sex gender,String email){
        this.setName(name);
        this.setGender(gender);
        this.setBirthday(birtd);
        this.setEmailAddress(email);
    }

    public int getAge() {

        return LocalDate.now().getYear() - this.getBirthday().getYear();
    }

    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printPerson() {
       System.out.println("Hi my name is "+getName()+" my gender is "+getGender()+" my email is "+getEmailAddress()+" and my birthday is "+getBirthday()+" and my age is "+ getAge());
    }
}
@java.lang.FunctionalInterface
interface CheckPerson<Person> {
    boolean test(Person p);
}