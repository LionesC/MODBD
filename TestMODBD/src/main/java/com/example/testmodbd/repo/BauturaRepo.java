package com.example.testmodbd.repo;

import com.example.testmodbd.model.Bautura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BauturaRepo {
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

    public BauturaRepo(){

    }

    public List<Bautura> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Bautura> bautura = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Bautura");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                bautura.add(new Bautura(resultSet.getInt("id_bautura"),
                        resultSet.getString("alcoolic")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return bautura;
    }

    public Bautura findById(int id_bautura) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Bautura bautura = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Bautura WHERE id_bautura = " + id_bautura);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                bautura = new Bautura(resultSet.getInt("id_bautura"),
                        resultSet.getString("alcoolic"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return bautura;
    }

    public void insert(Bautura bautura) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Bautura VALUES " + bautura.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Bautura entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Bautura SET alcoolic = ? WHERE id_bautura = ?");
            preparedStatement.setString(1, entity.getAlcoolic());
            preparedStatement.setInt(2, entity.getId_bautura());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_bautura) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Baututa WHERE id_baututa = " + id_bautura);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
