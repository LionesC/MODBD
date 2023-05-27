package com.example.testmodbd.model;

public class Pizza {
    int id_pizza;
    String tip_blat;
    String vegetarian;

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    public String getTip_blat() {
        return tip_blat;
    }

    public void setTip_blat(String tip_blat) {
        this.tip_blat = tip_blat;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Pizza(int id_pizza, String tip_blat, String vegetarian) {
        this.id_pizza = id_pizza;
        this.tip_blat = tip_blat;
        this.vegetarian = vegetarian;
    }

    public String getValues(){
        return "("
                + this.getId_pizza() + ".'"
                + this.getTip_blat() + "','"
                + this.getVegetarian() + "')";
    }
}
