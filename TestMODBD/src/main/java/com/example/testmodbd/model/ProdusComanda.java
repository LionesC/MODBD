package com.example.testmodbd.model;

public class ProdusComanda {
    int id_comanda;
    int id_produs;
    double pret;
    int cantitate;

    public int getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(int id_comanda) {
        this.id_comanda = id_comanda;
    }

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public ProdusComanda(int id_comanda, int id_produs, double pret, int cantitate) {
        this.id_comanda = id_comanda;
        this.id_produs = id_produs;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public String getValues(){
        return "("
                + this.getId_produs() + ","
                + this.getId_comanda() + ","
                + this.getPret() + ","
                + this.getCantitate() + ")";
    }
}
