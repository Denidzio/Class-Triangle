package com.company;

public class Main {

    public static void main(String[] args) {

        Triangle t1 = new Triangle(3, 4, 5);
//        Triangle t1 = new Triangle(3, 4, Math.toRadians(90));
//        Triangle t1 = new Triangle(3, Math.toRadians(53.13010235415599), Math.toRadians(90));

        System.out.println(t1.getSideA());
        System.out.println(t1.getSideB());
        System.out.println(t1.getSideC());

        System.out.println(Math.toDegrees(t1.getAngelAB()));
        System.out.println(Math.toDegrees(t1.getAngelAC()));
        System.out.println(Math.toDegrees(t1.getAngelBC()));

        System.out.println(t1.getPerimeter());
        System.out.println(t1.getArea());

//        t1.setSideC(10);

    }
}
