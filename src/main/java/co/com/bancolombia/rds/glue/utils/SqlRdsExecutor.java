package co.com.bancolombia.rds.glue.utils;

import co.com.bancolombia.rds.glue.models.Persons;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.rds.glue.utils.Constants.*;

public class SqlRdsExecutor {
    public static List<Persons> QueryRds() {
        List<Persons> personList = new ArrayList<>();
        // Configurar conexión JDBC
        try (Connection connection = DriverManager.getConnection(URL_CONNECTION_DATABASE, USER_DATABASE, PASSWORD_DATABASE)) {
            // Ejecuta tu consulta SQL
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(QUERY)) {
                // Resultados de la consulta
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    Persons person = new Persons(id, name, gender);
                    personList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }
}

