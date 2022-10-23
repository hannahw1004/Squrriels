package com.example.squrriels;

public class Car {
    public String brand;
    public String maker;
    public double emission;

    public Car(String brand, String maker, double emission){
        this.brand = brand;
        this.maker = maker;
        this.emission = emission;
    }

    public String toString(){
        return brand + " " + maker + " " + emission;
    }
}
