package com.example.testmodbd.repo;

import com.example.testmodbd.model.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaRepo {
    public static String urlGlobal = "jdbc:oracle:thin:@localhost:1521:orcl1";
    public static String urlLocalBuc = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String urlLocalProv = "jdbc:oracle:thin:@localhost:1521:orcl2";
    public static String utilizator = "c##proiect";
    public static String parola = "proiect";
    public static String driver = "oracle.jdbc.driver.OracleDriver";

    public Connection Conectare() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlGlobal, utilizator, parola);
        System.out.println("Conexiune reusita");
        return connection;
    }

    public PizzaRepo(){

    }

    public List<Pizza> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Pizza> pizza = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Pizza");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                pizza.add(new Pizza(resultSet.getInt("id_pizza"),
                        resultSet.getString("tip_blat"),
                        resultSet.getString("vegetarian")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return pizza;
    }

    public Pizza findById(int id_pizza) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Pizza pizza = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Pizza WHERE id_pizza = " + id_pizza);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                pizza = new Pizza(resultSet.getInt("id_pizza"),
                        resultSet.getString("tip_blat"),
                        resultSet.getString("vegetarian"));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return pizza;
    }

    public void insert(Pizza pizza) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Pizza VALUES " + pizza.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Pizza entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Pizza SET tip_blat = ?, vegetarian = ? WHERE id_pizza = ?");
            preparedStatement.setString(1, entity.getTip_blat());
            preparedStatement.setString(2, entity.getVegetarian());
            preparedStatement.setInt(3, entity.getId_pizza());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_pizza) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Pizza WHERE id_pizza = " + id_pizza);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
