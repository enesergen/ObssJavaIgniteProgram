package com.example.servletwithdbexample.DbOperation;

import com.example.servletwithdbexample.Contact.Contact;

import java.sql.*;
import java.util.ArrayList;

public class DbOperations {
    public static void addContact(Contact contact) throws SQLException {
        final String addQuery = "insert into \"Contacts\" (\"isim\",\"telefon\") values(?,?);";
        Connection connection = DBConnector.getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(addQuery)) {
            connection.setAutoCommit(false);//
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getTelnumber());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateContact(Contact contact) {
        final String updateQuery =
                "update \"Contacts\" set isim=? , telefon=? where id=?";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            connection.setAutoCommit(false);//
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getTelnumber());
            preparedStatement.setInt(3, contact.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Contact getOne(int id) {
        String getOne = "select * from \"Contacts\" where id=" + id;
        Contact contact = null;
        try (Connection connection = DBConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getOne);
            while (resultSet.next()) {
                contact = new Contact(resultSet.getInt("id"), resultSet.getString("isim"), resultSet.getString("telefon"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return contact;
    }

    public static ArrayList<Contact> getAllContact() {
        ArrayList<Contact> getAll = new ArrayList<>();
        String getAllQuery = "select * from \"Contacts\" order by id asc ;";
        try (Connection connection = DBConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAllQuery);
            while (resultSet.next()) {
                getAll.add(new Contact(resultSet.getInt("id")
                        , resultSet.getString("isim")
                        , resultSet.getString("telefon")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return getAll;
    }


/*
    public static List<Employee>getAllEmployee(OrderFiled orderFiled){
        List<Employee>employees=new ArrayList<>();
        final String readQuery = "select * from \"employee\" order by "+orderFiled.getOrderField();
        try(Connection connection = DBConnector.getConnection(); Statement statement=connection.createStatement()){

            ResultSet resultSet=statement.executeQuery(readQuery);
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("Surname");
                String title=resultSet.getString("title");
                int birthYear=resultSet.getInt("birthyear");
                employees.add(new Employee(id,name,surname,title,birthYear));
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return employees;
    }*/
}
