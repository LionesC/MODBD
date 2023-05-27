package com.example.testmodbd.repo;

import com.example.testmodbd.model.Produs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusRepo {
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

    public ProdusRepo() {

    }

    public List<Produs> findAll() throws ClassNotFoundException{

        ResultSet resultSet = null;
        List<Produs> produs = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Produs");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                produs.add(new Produs(resultSet.getInt("id_produs"),
                        resultSet.getString("nume"),
                        resultSet.getDouble("pret"),
                        resultSet.getString("categorie")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return produs;
    }

    public Produs findById(int id_produs) throws ClassNotFoundException{

        ResultSet resultSet = null;
        Produs produs = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Produs WHERE id_produs=" + id_produs);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                produs = new Produs(resultSet.getInt("id_produs"),
                        resultSet.getString("nume"),
                        resultSet.getDouble("pret"),
                        resultSet.getString("categorie"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return produs;
    }

    public void insert(Produs produs) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Produs VALUES" + produs.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Produs entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Produs SET nume = ?, pret = ?, categorie = ? WHERE id_produs = ?");
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setDouble(2, entity.getPret());
            preparedStatement.setString(3, entity.getCategorie());
            preparedStatement.setInt(4, entity.getId_produs());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_produs) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Produs WHERE id_produs=" + id_produs);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
