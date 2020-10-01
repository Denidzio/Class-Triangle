package com.company;

public class Main {

    public static void main(String[] args) {

        Triangle t1 = new Triangle(3, (double) 4, (double) 5);
        Triangle t2 = new Triangle(5, (double) 7, 30);
        Triangle t3 = new Triangle(5, 45, 45);

        System.out.println(t3.getArea());

        System.out.println(t3.getAngSndTrd());

        System.out.println(t3.getFirstSide());
        System.out.println(t3.getSecondSide());
        System.out.println(t3.getThirdSide());

    }
}
