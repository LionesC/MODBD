package com.example.testmodbd.model;

public class Adresa {
    int id_adresa;
    String cod_postal;
    String strada;
    int sector;
    String detalii;
    int id_oras_fk;

    public Adresa(int id_adresa, String cod_postal, String strada, int sector, String detalii, int id_oras_fk) {
        this.id_adresa = id_adresa;
        this.cod_postal = cod_postal;
        this.strada = strada;
        this.sector = sector;
        this.detalii = detalii;
        this.id_oras_fk = id_oras_fk;
    }

    public int getId_oras_fk() {
        return id_oras_fk;
    }

    public void setId_oras_fk(int id_oras_fk) {
        this.id_oras_fk = id_oras_fk;
    }

    public int getId_adresa() {
        return id_adresa;
    }

    public void setId_adresa(int id_adresa) {
        this.id_adresa = id_adresa;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public String getValues(){
        return "("
                + this.getId_adresa() + ",'"
                + this.getCod_postal() + "','"
                + this.getStrada() + "',"
                + this.getSector() + ",'"
                + this.getDetalii() + "',"
                + this.getId_oras_fk() + ")";
    }
}
