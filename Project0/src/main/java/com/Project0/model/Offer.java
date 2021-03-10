package com.Project0.model;

public class Offer {

    private int id;
    private float offer;
    private boolean accepted;

    public Offer(int id, float offer) {
        this.id = id;
        this.offer = offer;
    }

    public Offer(int id, float offer, boolean accepted) {
        this.id = id;
        this.offer = offer;
        this.accepted = accepted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getOffer() {
        return offer;
    }

    public void setOffer(float offer) {
        this.offer = offer;
    }

    public boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
