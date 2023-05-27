package com.example.testmodbd.model;

public class Livrare {
    int id_livrare;
    double pret;
    int id_client_fk;
    int id_angajat_fk;
    int id_adresa_fk;

    public int getId_client_fk() {
        return id_client_fk;
    }

    public void setId_client_fk(int id_client_fk) {
        this.id_client_fk = id_client_fk;
    }

    public int getId_angajat_fk() {
        return id_angajat_fk;
    }

    public void setId_angajat_fk(int id_angajat_fk) {
        this.id_angajat_fk = id_angajat_fk;
    }

    public int getId_adresa_fk() {
        return id_adresa_fk;
    }

    public void setId_adresa_fk(int id_adresa_fk) {
        this.id_adresa_fk = id_adresa_fk;
    }

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

    public Livrare(int id_livrare, double pret, int id_client_fk, int id_angajat_fk, int id_adresa_fk) {
        this.id_livrare = id_livrare;
        this.pret = pret;
        this.id_client_fk = id_client_fk;
        this.id_angajat_fk = id_angajat_fk;
        this.id_adresa_fk = id_adresa_fk;
    }

    public String getValues(){
        return "("
                + this.getId_livrare() + ","
                + this.getPret() + ","
                + this.getId_client_fk() + ","
                + this.getId_angajat_fk() + ","
                + this.getId_adresa_fk() + ")";
    }
}
