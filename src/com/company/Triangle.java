package com.company;

/* Created by IntelliJ IDEA.
Triangle (home task - Java).Triangle 
* @Author: Den1k
* @DateTime: 01.10.2020|19:00 
* @Version Triangle: 1.0
*/

import java.util.Objects;

public class Triangle {

    private double first_s; // First side;
    private double second_s; // Second side;
    private double third_s; // Third side;

    private float ang_fst_snd; // The angel between first and second sides;
    private float ang_snd_trd; // The angel between second and third sides;
    private float ang_trd_fst; // The angel between third and first sides;

    Triangle(double first_s, double second_s, double third_s) {

        if(first_s < 0 || second_s < 0 || third_s < 0)
            throw new IllegalArgumentException("Invalid argument entered");

        this.first_s = first_s;
        this.second_s = second_s;
        this.third_s = third_s;

        this.ang_fst_snd = getAngelBySides(first_s, second_s, third_s);
        this.ang_snd_trd = getAngelBySides(second_s, third_s, first_s);
        this.ang_trd_fst = 180 - (this.ang_fst_snd + this.ang_snd_trd);

    }

    Triangle(double first_s, double second_s, float ang_fst_snd) {

        if(first_s < 0 || second_s < 0 || ang_fst_snd < 0 || ang_fst_snd > 179)
            throw new IllegalArgumentException("Invalid argument entered");

        this.first_s = first_s;
        this.second_s = second_s;
        this.third_s = getSideBySidesAndAngel(first_s, second_s, ang_fst_snd);

        this.ang_fst_snd = ang_fst_snd;
        this.ang_snd_trd = getAngelBySides(this.second_s, this.third_s, this.first_s);
        this.ang_trd_fst = 180 - (this.ang_fst_snd + this.ang_snd_trd);

    }

    Triangle(double first_s, float ang_fst_snd, float ang_trd_fst) {

        if(first_s < 0 || (ang_fst_snd + ang_trd_fst) >= 180 || ang_fst_snd < 0 || ang_trd_fst < 0)
            throw new IllegalArgumentException("Invalid argument entered");

        this.first_s = first_s;
        this.ang_fst_snd = ang_fst_snd;
        this.ang_trd_fst = ang_trd_fst;

        this.third_s = getSideByAngelsAndSide(first_s, ang_fst_snd, ang_trd_fst);
        this.second_s = getSideBySidesAndAngel(this.first_s, this.third_s, this.ang_trd_fst);
        this.ang_snd_trd = 180 - (this.ang_fst_snd + this.ang_trd_fst);

    }

    public double getFirstSide() {
        return first_s;
    }

    public double getSecondSide() {
        return second_s;
    }

    public double getThirdSide() {
        return third_s;
    }

    public float getAngFstSnd() {
        return ang_fst_snd;
    }

    public float getAngSndTrd() {
        return ang_snd_trd;
    }

    public float getAngTrdFst() {
        return ang_trd_fst;
    }

    public void setFirstSide(double first_s) {
        this.first_s = first_s;
    }

    public void setSecondSide(double second_s) {
        this.second_s = second_s;
    }

    public void setThirdSide(double third_s) {
        this.third_s = third_s;
    }

    public void setAngFstSnd(float ang_fst_snd) {
        this.ang_fst_snd = ang_fst_snd;
    }

    public void setAngSndTrd(float ang_snd_trd) {
        this.ang_snd_trd = ang_snd_trd;
    }

    public void setAngTrdFst(float ang_trd_fst) {
        this.ang_trd_fst = ang_trd_fst;
    }

    public double getPerimeter(){
        return this.first_s + this.second_s + this.third_s;
    }

    public double getArea(){
        return this.getHeightToFirstSide() * this.first_s * 0.5;
    }

    public double getHeightToFirstSide(){
        return this.third_s * Math.sin( Math.toRadians(this.ang_trd_fst) );
    }

    public double getHeightToSecondSide(){
        return this.first_s * Math.sin( Math.toRadians(this.ang_fst_snd) );
    }

    public double getHeightToThirdSide(){
        return this.second_s * Math.sin( Math.toRadians(this.ang_snd_trd) );
    }

    public double getRadiusCircumscribedCircle(){
        return this.first_s * this.second_s * this.third_s / (4 * this.getArea());
    }

    public double getInscribedCircle(){
        return 2 * this.getArea() / this.getPerimeter();
    }

    private double getSideByAngelsAndSide(double side, float fst_angel, float snd_angel){
        return side * Math.sin( Math.toRadians(snd_angel)) / Math.sin( Math.toRadians(fst_angel + snd_angel) );
    }

    private double getSideBySidesAndAngel(double first_s, double second_s, float angel){
        return Math.sqrt( Math.pow(first_s, 2) + Math.pow(second_s, 2) - 2 * first_s * second_s * Math.cos(Math.toRadians(angel)) );
    }

    private float getAngelBySides(double first_s_btw, double second_s_btw, double third_s_front){
        return (float) Math.toDegrees( Math.acos( (Math.pow(first_s_btw, 2) + Math.pow(second_s_btw, 2) - Math.pow(third_s_front, 2)) / (2 * first_s_btw * second_s_btw) ) );
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "first_s=" + first_s +
                ", second_s=" + second_s +
                ", third_s=" + third_s +
                ", ang_fst_snd=" + ang_fst_snd +
                ", ang_snd_trd=" + ang_snd_trd +
                ", ang_trd_fst=" + ang_trd_fst +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.first_s, first_s) == 0 &&
                Double.compare(triangle.second_s, second_s) == 0 &&
                Double.compare(triangle.third_s, third_s) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_s, second_s, third_s);
    }
}