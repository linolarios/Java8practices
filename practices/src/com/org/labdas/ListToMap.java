package com.org.labdas;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by STO on 31/03/2016.
 */
public class ListToMap {


    final static String salutation = "Hello! ";


    public static void main(String[] args) {

        List<Hosting> list = new ArrayList<Hosting>();
        list.add(new Hosting(1, "liquidweb.com", new Date()));
        list.add(new Hosting(2, "linode.com", new Date()));
        list.add(new Hosting(3, "digitalocean.com", new Date()));

        //example 1
        Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getId, Hosting::getName));

        System.out.println("Result 1 : " + result1);

        //example 2
        Map<Integer, String> result2 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 2 : " + result2);

        Runnable noArguments = () -> System.out.println("Hello World");

         final  ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

        System.out.println(formatter.get());

        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Mahesh");

    }


    interface GreetingService {
        void sayMessage(String message);
    }
}






