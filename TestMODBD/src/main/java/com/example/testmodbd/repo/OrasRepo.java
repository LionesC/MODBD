package com.example.testmodbd.repo;
import com.example.testmodbd.model.Oras;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrasRepo {
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

    public OrasRepo(){

    }


    public List<Oras> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Oras> oras = new ArrayList<>();

        try{

            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Oras");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                oras.add(new Oras(resultSet.getInt("id_oras"),
                        resultSet.getString("nume")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return oras;
    }

    public Oras findById(int id_oras) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Oras oras = null;

        try{

            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Oras WHERE id_oras=" + id_oras);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                oras = new Oras(resultSet.getInt("id_oras"),
                                resultSet.getString("nume"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return oras;
    }

    public void insert(Oras oras) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Oras VALUES " + oras.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Oras entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Oras SET nume = ? WHERE id_oras = ?");
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setInt(2, entity.getId_oras());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id_oras) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Oras WHERE id_oras=" + id_oras);
            preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
