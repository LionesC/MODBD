package com.example.testmodbd.model;

public class Oras {

    int id_oras;
    String nume;

    public Oras(int id_oras, String nume) {
        this.id_oras = id_oras;
        this.nume = nume;
    }

    public int getId_oras() {
        return id_oras;
    }

    public void setId_oras(int id_oras) {
        this.id_oras = id_oras;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Oras getOras(int id_oras, String nume) {
        Oras oras = new Oras(this.id_oras = id_oras, this.nume = nume);
        return oras;
    }

    public String getValues() {
        return "("
                + this.getId_oras() + ", '"
                + this.getNume()
                + "')";
    }

}
