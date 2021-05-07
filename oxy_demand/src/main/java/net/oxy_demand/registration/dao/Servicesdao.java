package net.oxy_demand.registration.dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import net.oxy_demand.registration.model.Services;

public class Servicesdao {
	public int registration(Services employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO oxy_supply" +
            "  (Full_Name,Address_Line1,Address_Line2,State,City,Aaddhar_Number,Mobile_Number) VALUES " +
            " (?,?,?,?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/oxygen", "root", "tiger");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1,employee.getFullname());
            preparedStatement.setString(2,employee.getAdd1());
            preparedStatement.setString(3,employee.getAdd2());
            preparedStatement.setString(4,employee.getState());
            preparedStatement.setString(5,employee.getCity());
            preparedStatement.setString(6,employee.getAdhar());
            preparedStatement.setString(7,employee.getMobile());
            
            

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
