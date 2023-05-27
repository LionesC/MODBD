package com.example.testmodbd.repo;

import com.example.testmodbd.model.Livrare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivrareRepo {
    public static String urlGlobal = "jdbc:oracle:thin:@localhost:1521:orcl1";
    public static String urlLocalBuc = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String urlLocalProv = "jdbc:oracle:thin:@localhost:1521:orcl2";
    public static String utilizator = "c##proiect";
    public static String parola = "proiect";
    public static String driver = "oracle.jdbc.driver.OracleDriver";

    public LivrareRepo(){

    }

    public Connection Conectare() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlGlobal, utilizator, parola);
        System.out.println("Conexiune reusita");
        return connection;
    }

    public List<Livrare> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Livrare> livrare = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Livrare");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                livrare.add(new Livrare(resultSet.getInt("id_livrare"),
                        resultSet.getDouble("pret"),
                        resultSet.getInt("id_client_fk"),
                        resultSet.getInt("id_angajat_fk"),
                        resultSet.getInt("id_adresa_fk")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return livrare;
    }

    public Livrare findById(int id_livrare) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Livrare livrare = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Livrare WHERE id_livrare=" + id_livrare);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                livrare = new Livrare(resultSet.getInt("id_livrare"),
                        resultSet.getDouble("pret"),
                        resultSet.getInt("id_client_fk"),
                        resultSet.getInt("id_angajat_fk"),
                        resultSet.getInt("id_adresa_fk"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return livrare;
    }

    public void insert(Livrare livrare) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Livrare VALUES " + livrare.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Livrare entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Livrare SET pret = ?, id_client_fk = ?, id_angajat_fk = ?, id_adresa_fk = ? WHERE id_livrare = ?");
            preparedStatement.setDouble(1, entity.getPret());
            preparedStatement.setInt(2, entity.getId_client_fk());
            preparedStatement.setInt(3, entity.getId_angajat_fk());
            preparedStatement.setInt(4, entity.getId_adresa_fk());
            preparedStatement.setInt(5, entity.getId_livrare());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id_livrare) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Livrare WHERE id_livrare=" + id_livrare);
            preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
