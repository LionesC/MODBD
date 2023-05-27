package com.example.testmodbd.model;

public class Comanda {
    int id_comanda;
    double pret;
    String detalii;
    int id_livrare;
    int id_angajat;
    int id_client;

    public int getId_livrare() {
        return id_livrare;
    }

    public void setId_livrare(int id_livrare) {
        this.id_livrare = id_livrare;
    }

    public int getId_angajat() {
        return id_angajat;
    }

    public void setId_angajat(int id_angajat) {
        this.id_angajat = id_angajat;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

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

    public Comanda(int id_comanda, double pret, String detalii, int id_livrare, int id_angajat, int id_client) {
        this.id_comanda = id_comanda;
        this.pret = pret;
        this.detalii = detalii;
        this.id_livrare = id_livrare;
        this.id_comanda = id_comanda;
        this.id_angajat = id_angajat;
    }

    public String getValues(){
        return "("
                + this.getPret() + ",'"
                + this.getDetalii() + "',"
                + this.getId_livrare() + ","
                + this.getId_angajat() + ","
                + this.getId_client() + ")";
    }
}
