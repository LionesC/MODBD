package com.example.testmodbd.repo;

import com.example.testmodbd.model.ProdusComanda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusComandaRepo {
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

    public ProdusComandaRepo(){

    }

    public List<ProdusComanda> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<ProdusComanda> produsComanda = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM ProdusComanda");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                produsComanda.add(new ProdusComanda(resultSet.getInt("id_comanda"),
                        resultSet.getInt("id_produs"),
                        resultSet.getDouble("pret"),
                        resultSet.getInt("cantitate")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return produsComanda;
    }

    public ProdusComanda findById(int id_produs, int id_comanda) throws ClassNotFoundException{
        ResultSet resultSet = null;
        ProdusComanda produsComanda = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM ProdusComanda WHERE id_produs =" + id_produs + " AND id_comanda =" + id_comanda);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                produsComanda = new ProdusComanda(resultSet.getInt("id_comanda"),
                        resultSet.getInt("id_produs"),
                        resultSet.getDouble("pret"),
                        resultSet.getInt("cantitate"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return produsComanda;
    }

    public void insert (ProdusComanda produsComanda) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO ProdusComanda VALUES " + produsComanda.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(ProdusComanda entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE ProdusComanda SET pret = ?, cantitate = ? WHERE id_produs = ? AND id_comanda = ?");
            preparedStatement.setDouble(1, entity.getPret());
            preparedStatement.setInt(2, entity.getCantitate());
            preparedStatement.setInt(3, entity.getId_produs());
            preparedStatement.setInt(4, entity.getId_comanda());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_produs, int id_comanda) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM ProdusComanda WHERE id_produs = " + id_produs + " AND id_comanda = " + id_comanda);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
