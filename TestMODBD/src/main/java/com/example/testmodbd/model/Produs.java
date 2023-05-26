package com.example.testmodbd.model;

public class Produs {
    int id_produs;
    String nume;
    double pret;
    String categorie;

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Produs(int id_produs, String nume, double pret, String categorie) {
        this.id_produs = id_produs;
        this.nume = nume;
        this.pret = pret;
        this.categorie = categorie;
    }
}
