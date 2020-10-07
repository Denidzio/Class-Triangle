package com.company;

/* Created by IntelliJ IDEA.
Triangle (home task - Java).Triangle 
* @Author: Den1k
* @DateTime: 01.10.2020|19:00 
* @Version Triangle: 1.1
*/

import java.util.Objects;

public class Triangle {

    private float side_a;
    private float side_b;
    private float side_c;

    Triangle(float side_a, float side_b, float side_c){

        if(!isValid(side_a, side_b, side_c))
            throw new IllegalArgumentException("Triangle isn't valid!");

        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;

    }

    Triangle(float side_a, float side_b, double angel_a_b){

        float side_c = getSideBySidesAndAngel(side_a, side_b, angel_a_b);

        if(!isValid(side_a, side_b, side_c))
            throw new IllegalArgumentException("Triangle isn't valid!");

        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;

    }

    Triangle(float side_a, double angel_a_b, double angel_c_a){

        float side_c = getSideByAngelsAndSide(side_a, angel_a_b, angel_c_a);
        float side_b = getSideBySidesAndAngel(side_a, side_c, angel_a_b);

        if(!isValid(side_a, side_b, side_c))
            throw new IllegalArgumentException("Triangle isn't valid!");

        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;

    }

    public float getSideA() {
        return side_a;
    }

    public void setSideA(float side_a) {
        if(!isValid(side_a, this.side_b, this.side_c))
            throw new IllegalArgumentException("Triangle isn't valid!");

        this.side_a = side_a;
    }

    public float getSideB() {
        return side_b;
    }

    public void setSideB(float side_b) {
        if(!isValid(this.side_a, side_b, this.side_c))
            throw new IllegalArgumentException("Triangle isn't valid!");

        this.side_b = side_b;
    }

    public float getSideC() {
        return side_c;
    }

    public void setSideC(float side_c) {
        if(!isValid(this.side_a, this.side_b, side_c))
            throw new IllegalArgumentException("Triangle isn't valid!");

        this.side_c = side_c;
    }

    public double getAngelAB(){
        return getAngelBySides(this.side_a, this.side_b, this.side_c);
    }

    public double getAngelBC(){
        return getAngelBySides(this.side_b, this.side_c, this.side_a);
    }

    public double getAngelAC(){
        return getAngelBySides(this.side_a, this.side_c, this.side_b);
    }

    public double getPerimeter(){
        return this.side_a + this.side_b + this.side_c;
    }

    public double getArea(){
        return this.getHeightToFirstSide() * this.side_a * 0.5;
    }

    public double getHeightToFirstSide(){
        return this.side_c * Math.sin(this.getAngelAC());
    }

    public double getHeightToSecondSide(){
        return this.side_a * Math.sin(this.getAngelAB());
    }

    public double getHeightToThirdSide(){
        return this.side_c * Math.sin(this.getAngelBC());
    }

    public double getRadiusCircumscribedCircle(){
        return this.side_a * this.side_b * this.side_c / (4 * this.getArea());
    }

    public double getInscribedCircle(){
        return 2 * this.getArea() / this.getPerimeter();
    }

    static float getSideBySidesAndAngel(float side_a, float side_b, double angel){
        return (float) Math.sqrt( Math.pow(side_a, 2) + Math.pow(side_b, 2) - 2 * side_a * side_b * Math.cos(angel) );
    }

    static private float getSideByAngelsAndSide(float side, double fst_angel, double snd_angel){
        return side * (float)Math.sin(snd_angel) / (float)Math.sin(fst_angel + snd_angel);
    }

    static private double getAngelBySides(float side_a_btw, float side_b_btw, float side_c_front){
        return Math.acos( (Math.pow(side_a_btw, 2) + Math.pow(side_b_btw, 2) - Math.pow(side_c_front, 2)) / (2 * side_a_btw * side_b_btw) );
    }

    static private boolean isValid(float side_a, float side_b, float side_c){
        return  (side_a + side_b < side_c) ||
                (side_b + side_c < side_a) ||
                (side_a + side_c < side_b) ? false : true;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side_a=" + side_a +
                ", side_b=" + side_b +
                ", side_c=" + side_c +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.side_a, side_a) == 0 &&
                Float.compare(triangle.side_b, side_b) == 0 &&
                Float.compare(triangle.side_c, side_c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side_a, side_b, side_c);
    }
}