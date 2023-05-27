package com.example.testmodbd.repo;

import com.example.testmodbd.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepo {
    public static String urlGlobal = "jdbc:oracle:thin:@localhost:1521:orcl1";
    public static String urlLocalBuc = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String urlLocalProv = "jdbc:oracle:thin:@localhost:1521:orcl2";
    public static String utilizator = "c##proiect";
    public static String parola = "proiect";
    public static String driver = "oracle.jdbc.driver.OracleDriver";

    public ClientRepo(){

    }

    public Connection Conectare() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlGlobal, utilizator, parola);
        System.out.println("Conexiune reusita");
        return connection;
    }

    public List<Client> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Client> client = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Client");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                client.add(new Client(resultSet.getInt("id_client"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("email"),
                        resultSet.getString("nr_telefon")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    public Client findById(int id_client) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Client client = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Client WHERE id_client=" + id_client);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                client = new Client(resultSet.getInt("id_client"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("email"),
                        resultSet.getString("nr_telefon"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    public void insert(Client client) throws  ClassNotFoundException{
        try{
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Client VALUES " + client.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Client entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Client SET nume = ?, prenume = ?, email = ?, nr_telefon = ? WHERE id_client = ?");
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setString(2, entity.getPrenume());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getNr_telefon());
            preparedStatement.setInt(5, entity.getId_client());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_client) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Client WHERE id_client=" + id_client);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
