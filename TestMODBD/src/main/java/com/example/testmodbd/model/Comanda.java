package com.example.testmodbd.model;

public class Comanda {
    int id_comanda;
    double pret;
    String detalii;

    public int getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(int id_comanda) {
        this.id_comanda = id_comanda;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public Comanda(int id_comanda, double pret, String detalii) {
        this.id_comanda = id_comanda;
        this.pret = pret;
        this.detalii = detalii;
    }
}
