package com.example.testmodbd.repo;

import com.example.testmodbd.model.Comanda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaRepo {
    public static String urlGlobal = "jdbc:oracle:thin:@localhost:1521:orcl1";
    public static String urlLocalBuc = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String urlLocalProv = "jdbc:oracle:thin:@localhost:1521:orcl2";
    public static String utilizator = "c##proiect";
    public static String parola = "proiect";
    public static String driver = "oracle.jdbc.driver.OracleDriver";

    public ComandaRepo(){

    }

    public Connection Conectare() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlGlobal, utilizator, parola);
        System.out.println("Conexiune reusita");
        return connection;
    }

    public List<Comanda> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Comanda> comanda = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Comanda");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                comanda.add(new Comanda(resultSet.getInt("id_comanda"),
                        resultSet.getDouble("pret"),
                        resultSet.getString("detalii"),
                        resultSet.getInt("id_livrare"),
                        resultSet.getInt("id_angajat"),
                        resultSet.getInt("id_client")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return comanda;
    }

    public Comanda findById(int id_comanda) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Comanda comanda = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Comanda WHERE id_comanda=" + id_comanda);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                comanda = new Comanda(resultSet.getInt("id_comanda"),
                        resultSet.getDouble("pret"),
                        resultSet.getString("detalii"),
                        resultSet.getInt("id_livrare"),
                        resultSet.getInt("id_angajat"),
                        resultSet.getInt("id_client"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return comanda;
    }

    public void insert(Comanda comanda) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Comanda VALUES " + comanda.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Comanda entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Comanda SET pret = ?, detalii = ?, WHERE id_comanda = ?");
            preparedStatement.setDouble(1, entity.getPret());
            preparedStatement.setString(2, entity.getDetalii());
            preparedStatement.setInt(3, entity.getId_comanda());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_comanda) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Comanda WHERE id_comanda=" + id_comanda);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
