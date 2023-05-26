package com.example.testmodbd.repo;
import com.example.testmodbd.model.Angajat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AngajatRepo {
    public static String urlGlobal = "jdbc:oracle:thin:@localhost:1521:orcl1";
    public static String urlLocalBuc = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String urlLocalProv = "jdbc:oracle:thin:@localhost:1521:orcl2";
    public static String utilizator = "c##proiect";
    public static String parola = "proiect";
    public static String driver = "oracle.jdbc.driver.OracleDriver";

    public AngajatRepo(){

    }

    public Connection Conectare() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlGlobal, utilizator, parola);
        System.out.println("Conexiune reusita");
        return connection;
    }

    public List<Angajat> findAll() throws ClassNotFoundException{
        ResultSet resultSet = null;
        List<Angajat> angajat = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Angajat");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                angajat.add(new Angajat(resultSet.getInt("id_angajat"),
                        resultSet.getString("nume"),
                        resultSet.getString("nr_telefon"),
                        resultSet.getString("rol"),
                        resultSet.getInt("cnp"),
                        resultSet.getDouble("salariu"),
                        resultSet.getString("iban"),
                        resultSet.getInt("id_magazin_fk")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return angajat;
    }

    public Angajat findById(int id_angajat) throws ClassNotFoundException{
        ResultSet resultSet = null;
        Angajat angajat = null;

        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("SELECT * FROM Angajat WHERE id_angajat=" + id_angajat);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                angajat = new Angajat(resultSet.getInt("id_angajat"),
                        resultSet.getString("nume"),
                        resultSet.getString("nr_telefon"),
                        resultSet.getString("rol"),
                        resultSet.getInt("cnp"),
                        resultSet.getDouble("salariu"),
                        resultSet.getString("iban"),
                        resultSet.getInt("id_magazin_fk"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return angajat;
    }

    public void insert(Angajat angajat) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("INSERT INTO Angajat VALUES " + angajat.getValues());
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Angajat entity) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("UPDATE Angajat SET nume = ?, nr_telefon = ?, rol = ?, cnp = ?, salariu = ?, iban = ?, id_magazin_fk = ? WHERE id_angajat = ?");
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setString(2, entity.getNr_telefon());
            preparedStatement.setString(3, entity.getRol());
            preparedStatement.setInt(4, entity.getCnp());
            preparedStatement.setDouble(5, entity.getSalariu());
            preparedStatement.setString(6, entity.getIban());
            preparedStatement.setInt(7, entity.getId_magazin_fk());
            preparedStatement.setInt(8, entity.getId_angajat());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id_angajat) throws ClassNotFoundException{
        try {
            PreparedStatement preparedStatement = Conectare().prepareStatement("DELETE FROM Angajat WHERE id_angajat=" + id_angajat);
            preparedStatement.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
