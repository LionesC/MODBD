package com.example.testmodbd.model;

public class Magazin {
    int id_magazin;
    String nume;
    int id_adresa_fk;

    public int getId_adresa_fk() {
        return id_adresa_fk;
    }

    public void setId_adresa_fk(int id_adresa_fk) {
        this.id_adresa_fk = id_adresa_fk;
    }

    public int getId_magazin() {
        return id_magazin;
    }

    public void setId_magazin(int id_magazin) {
        this.id_magazin = id_magazin;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Magazin(int id_magazin, String nume, int id_adresa_fk) {
        this.id_magazin = id_magazin;
        this.nume = nume;
        this.id_adresa_fk = id_adresa_fk;
    }

    public String getValues(){
        return "("
                + this.getId_magazin() + ",'"
                + this.getNume() + "',"
                + this.getId_adresa_fk() + ")";
    }
}
