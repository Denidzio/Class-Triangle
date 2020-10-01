package com.company;

public class Main {

    public static void main(String[] args) {

//        Triangle r1 = new Triangle(3, (double) 4, (double) 5);
        Triangle r2 = new Triangle(5, (double) 7, 30);
//        Triangle r3 = new Triangle(5, 30, 45);

        System.out.println(r2.getArea());

        System.out.println(r2.getHeightToFirstSide());
        System.out.println(r2.getHeightToSecondSide());
        System.out.println(r2.getHeightToThirdSide());

    }
}
