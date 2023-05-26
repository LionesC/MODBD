package com.example.testmodbd.model;

public class Angajat {
    int id_angajat;
    String nume;
    String nr_telefon;
    String rol;
    int cnp;
    double salariu;
    String iban;
    int id_magazin_fk;

    public int getId_magazin_fk() {
        return id_magazin_fk;
    }

    public void setId_magazin_fk(int id_magazin_fk) {
        this.id_magazin_fk = id_magazin_fk;
    }

    public Angajat(int id_angajat, String nume, String nr_telefon, String rol, int cnp, double salariu, String iban, int id_magazin_fk) {
        this.id_angajat = id_angajat;
        this.nume = nume;
        this.nr_telefon = nr_telefon;
        this.rol = rol;
        this.cnp = cnp;
        this.salariu = salariu;
        this.iban = iban;
        this.id_magazin_fk = id_magazin_fk;
    }

    public int getId_angajat() {
        return id_angajat;
    }

    public void setId_angajat(int id_angajat) {
        this.id_angajat = id_angajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNr_telefon() {
        return nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getValues(){
        return "("
                + this.getId_angajat() + ",'"
                + this.getNume() + "','"
                + this.getNr_telefon() + "','"
                + this.getRol() + "',"
                + this.getCnp() + ","
                + this.getSalariu() + ",'"
                + this.getIban() + "',"
                + this.getId_magazin_fk() + ")";
    }
}
