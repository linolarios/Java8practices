package com.org.labdas;

/**
 * Created by STO on 05/04/2016.
 */
public class DefaultMethods {

    public static void main(String args[]){
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}

interface Vehicle {
    default void print(){
        System.out.println("I am a vehicle!");
    }

    static void blowHorn(){
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}
