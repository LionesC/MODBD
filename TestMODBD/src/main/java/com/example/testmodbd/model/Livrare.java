package com.example.testmodbd.model;

public class Livrare {
    int id_livrare;
    double pret;

    public int getId_livrare() {
        return id_livrare;
    }

    public void setId_livrare(int id_livrare) {
        this.id_livrare = id_livrare;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public Livrare(int id_livrare, double pret) {
        this.id_livrare = id_livrare;
        this.pret = pret;
    }
}
