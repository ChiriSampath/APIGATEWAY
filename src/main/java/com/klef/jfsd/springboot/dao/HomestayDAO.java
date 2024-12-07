package com.klef.jfsd.springboot.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.klef.jfsd.springboot.model.Homestay;

public class HomestayDAO {

    private final String url = "jdbc:mysql://localhost:3306/tourismdb";
    private final String username = "root";
    private final String password = "Sailesh@456";

    public List<Homestay> getAllHomestays() {
        List<Homestay> homestays = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM homestay";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Homestay homestay = new Homestay();
                homestay.setId(resultSet.getLong("id"));
                homestay.setName(resultSet.getString("name"));
                homestay.setLocation(resultSet.getString("location"));
                homestay.setPrice(resultSet.getDouble("price"));
                homestay.setAmenities(resultSet.getString("amenities"));
                homestays.add(homestay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homestays;
    }

    public void addHomestay(Homestay homestay) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO homestay (name, location, price, amenities) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, homestay.getName());
            statement.setString(2, homestay.getLocation());
            statement.setDouble(3, homestay.getPrice());
            statement.setString(4, homestay.getAmenities());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional CRUD methods for update and delete
}
