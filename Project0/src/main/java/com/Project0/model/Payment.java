package com.Project0.model;

public class Payment {

    private int id;
    private float due;
    private int ddy;
    private int ddm;
    private int ddd;

    public Payment(float due, int ddy, int ddm, int ddd) { //id serial
        this.due = due;
        this.ddy = ddy;
        this.ddm = ddm;
        this.ddd = ddd;
    }

    public Payment(int id, float due, int ddy, int ddm, int ddd) {
        this.id = id;
        this.due = due;
        this.ddy = ddy;
        this.ddm = ddm;
        this.ddd = ddd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public int getDdy() {
        return ddy;
    }

    public void setDdy(int ddy) {
        this.ddy = ddy;
    }

    public int getDdm() {
        return ddm;
    }

    public void setDdm(int ddm) {
        this.ddm = ddm;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }
}
