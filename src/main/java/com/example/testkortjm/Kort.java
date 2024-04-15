package com.example.testkortjm;

public class Kort {
    private String type;
    private int nummer; // Endret til int fordi nummer vanligvis er en tallverdi

    public Kort() {
        // Tom konstruktør kreves for JPA
    }

    public Kort(String type, int nummer) {
        this.type = type;
        this.nummer = nummer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}
