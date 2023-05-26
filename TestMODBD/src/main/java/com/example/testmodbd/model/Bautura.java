package com.example.testmodbd.model;

public class Bautura {
    int id_bautura;
    String alcoolic;

    public int getId_bautura() {
        return id_bautura;
    }

    public void setId_bautura(int id_bautura) {
        this.id_bautura = id_bautura;
    }

    public String getAlcoolic() {
        return alcoolic;
    }

    public void setAlcoolic(String alcoolic) {
        this.alcoolic = alcoolic;
    }

    public Bautura(int id_bautura, String alcoolic) {
        this.id_bautura = id_bautura;
        this.alcoolic = alcoolic;
    }
}
