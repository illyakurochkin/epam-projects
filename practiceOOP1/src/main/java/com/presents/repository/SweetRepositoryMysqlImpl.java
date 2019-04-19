package com.presents.repository;

import com.presents.sweets.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

public class SweetRepositoryMysqlImpl implements SweetRepository {

    public static final String CREATE_TABLES_SQL =
            "CREATE TABLE `sweets` (\n" +
                    "  `id` INT unsigned NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(255) NOT NULL,\n" +
                    "  `brand` VARCHAR(255) NOT NULL,\n" +
                    "  `weight` INT unsigned NOT NULL,\n" +
                    "  `sugar_weight` INT unsigned NOT NULL,\n" +
                    "  `date_of_manufacture` DATE NOT NULL,\n" +
                    "  `expiration_days` INT unsigned NOT NULL,\n" +
                    "  `type` VARCHAR(255) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");\n";

    private Connection connection;
    private Statement statement;

    private void openConnection() {
        try {
            if(connection != null && !connection.isClosed()) {
                closeConnection();
            }
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sweet","root","root");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if(connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Sweet buildSweet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String brand = resultSet.getString("brand");
        int weight = resultSet.getInt("weight");
        int sugarWeight = resultSet.getInt("sugar_weight");
        LocalDate dateOfManufacture = resultSet.getDate("date_of_manufacture").toLocalDate();
        int expirationDays = resultSet.getInt("expiration_days");
        String type = resultSet.getString("type");

        if(type.startsWith("Cake")) {
            return Cake.builder()
                    .withId(id)
                    .withName(name)
                    .withBrand(brand)
                    .withDateOfManufacture(dateOfManufacture)
                    .withExpirationDays(expirationDays)
                    .build();

        } else if (type.startsWith("Candy")) {
            return Candy.builder()
                    .withId(id)
                    .withName(name)
                    .withBrand(brand)
                    .withDateOfManufacture(dateOfManufacture)
                    .withExpirationDays(expirationDays)
                    .build();

        } else if (type.startsWith("Cookie")) {
            return Cookie.builder()
                    .withId(id)
                    .withName(name)
                    .withBrand(brand)
                    .withDateOfManufacture(dateOfManufacture)
                    .withExpirationDays(expirationDays)
                    .build();

        } else if (type.startsWith("Muffin")) {
            return Muffin.builder()
                    .withId(id)
                    .withName(name)
                    .withBrand(brand)
                    .withDateOfManufacture(dateOfManufacture)
                    .withExpirationDays(expirationDays)
                    .build();
        }
        return Sweet.builder()
                .withId(id)
                .withName(name)
                .withBrand(brand)
                .withDateOfManufacture(dateOfManufacture)
                .withExpirationDays(expirationDays)
                .build();
    }

    public SweetRepositoryMysqlImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Sweet> selectAll() {
        Set<Sweet> sweets = new HashSet<>();
        openConnection();
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM sweets;")) {
            while(resultSet.next()) {
                sweets.add(buildSweet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return sweets;
    }

    @Override
    public Set<Sweet> select(Set<Integer> ids) {
        String sql = "SELECT * FROM sweets WHERE" +
                ids.stream()
                .map(id -> "`id` = " + id)
                .collect(joining(" OR ")) + ';';

        Set<Sweet> sweets = new HashSet<>();
        openConnection();
        try (ResultSet resultSet = statement.executeQuery(sql)) {
            while(resultSet.next()) {
                sweets.add(buildSweet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return sweets;
    }

    @Override
    public void delete(Set<Integer> ids) {
        openConnection();
        String sql = "DELETE FROM sweets WHERE " +
                ids.stream()
                .map(id -> "id = " + id)
                .collect(joining(" OR ")) + ';';

        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    @Override
    public void insert(Set<Sweet> sweets) {
        openConnection();
        String sql = "INSERT INTO sweets (`id`, `name`, `brand`, `weight`, " +
                "`sugar_weight`, `date_of_manufacture`, `expiration_days`, `type`) VALUES " +
                sweets.stream()
                    .map(sweet -> String.format("(%d, \"%s\", \"%s\", %d, %d, \"%s\", %d, \"%s\")",
                            sweet.getId(), sweet.getName(), sweet.getBrand(), sweet.getWeight(), sweet.getSugarWeight(),
                            sweet.getDateOfManufacture().toString(), sweet.getExpirationDays(),
                            sweet.getClass().getSimpleName())).collect(joining(", "))
                + ";";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    @Override
    public Set<Sweet> selectByName(String name) {
        String sql = "SELECT * FROM sweets WHERE `name` = \"" + name + "\";";

        Set<Sweet> sweets = new HashSet<>();
        openConnection();

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                sweets.add(buildSweet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
        return sweets;
    }

    @Override
    public Set<Sweet> selectByBrand(String brand) {
        String sql = "SELECT * FROM sweets WHERE `brand` = \"" + brand + "\";";

        Set<Sweet> sweets = new HashSet<>();
        openConnection();

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                sweets.add(buildSweet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
        return sweets;
    }
}
