package com.example.testmodbd.repo;

import com.example.testmodbd.model.Adresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresaRepo {

    public static String urlGlobal = "jdbc:oracle:thin:@localhost:1521:orcl1";
    public static String urlLocalBuc = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String urlLocalProv = "jdbc:oracle:thin:@localhost:1521:orcl2";
    public static String utilizator = "c##proiect";
    public static String parola = "proiect";
    public static String driver = "oracle.jdbc.driver.OracleDriver";

    public AdresaRepo(){

    }

    public Connection Conectare() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlGlobal, utilizator, parola);
        System.out.println("Conexiune reusita");
        return connection;
    }

    public List<Adresa> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Adresa> adresa = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Adresa");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                adresa.add(new Adresa(resultSet.getInt("id_adresa"),
                        resultSet.getString("cod_postal"),
                        resultSet.getString("strada"),
                        resultSet.getInt("sector"),
                        resultSet.getString("detalii"),
                        resultSet.getInt("id_oras_fk")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return adresa;
    }

    public Adresa findById(int id_adresa) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Adresa adresa = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Adresa WHERE id_adresa=" + id_adresa);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                adresa = new Adresa(resultSet.getInt("id_adresa"),
                        resultSet.getString("cod_postal"),
                        resultSet.getString("strada"),
                        resultSet.getInt("sector"),
                        resultSet.getString("detalii"),
                        resultSet.getInt("id_oras_fk"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return adresa;
    }

    public void insert(Adresa adresa) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Adresa VALUES " + adresa.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Adresa entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Adresa SET cod_postal = ?, strada = ?, sector = ?, detalii = ?, id_oras_fk = ? WHERE id_adresa = ?");
            preparedStatement.setString(1, entity.getCod_postal());
            preparedStatement.setString(2, entity.getStrada());
            preparedStatement.setInt(3, entity.getSector());
            preparedStatement.setString(4, entity.getDetalii());
            preparedStatement.setInt(5, entity.getId_oras_fk());
            preparedStatement.setInt(6, entity.getId_adresa());

            preparedStatement.executeUpdate();
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_adresa) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Adresa WHERE id_adresa=" + id_adresa);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
