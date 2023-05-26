package com.example.testmodbd.repo;

import com.example.testmodbd.model.Magazin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagazinRepo {
    public static String urlGlobal = "jdbc:oracle:thin:@localhost:1521:orcl1";
    public static String urlLocalBuc = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String urlLocalProv = "jdbc:oracle:thin:@localhost:1521:orcl2";
    public static String utilizator = "c##proiect";
    public static String parola = "proiect";
    public static String driver = "oracle.jdbc.driver.OracleDriver";

    public MagazinRepo(){

    }

    public Connection Conectare() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlGlobal, utilizator, parola);
        System.out.println("Conexiune reusita");
        return connection;
    }

    public List<Magazin> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Magazin> magazin = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Magazin");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                magazin.add(new Magazin(resultSet.getInt("id_magazin"),
                        resultSet.getString("nume"),
                        resultSet.getInt("id_adresa_fk")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return magazin;
    }

    public Magazin findById(int id_magazin) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Magazin magazin = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Magazin WHERE id_magazin=" + id_magazin);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                magazin = new Magazin(resultSet.getInt("id_magazin"),
                        resultSet.getString("nume"),
                        resultSet.getInt("id_adresa_fk"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return magazin;
    }

    public void insert(Magazin magazin) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Magazin VALUES " + magazin.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Magazin entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Magazin SET nume = ?, id_adresa_fk = ? WHERE id_magazin = ?");
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setInt(2, entity.getId_adresa_fk());
            preparedStatement.setInt(3, entity.getId_magazin());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_magazin) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Magazin WHERE id_magazin=" + id_magazin);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
