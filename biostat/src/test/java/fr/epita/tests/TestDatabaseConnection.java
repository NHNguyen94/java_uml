package fr.epita.tests;

import java.sql.*;

public class TestDatabaseConnection {
    public static void main(String[] args) throws SQLException {
        Connection conection =
                DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");
        PreparedStatement preparedStatement =
                conection.prepareStatement(
                        "CREATE TABLE TEST_PERSONS(" +
                                "name varchar(255)," +
                                "gender varchar(255)," +
                                "age int," +
                                "height int," +
                                "weight int" +
                                ")"
                );
        preparedStatement.execute();

        String sqlInsert =
                "INSERT INTO TEST_PERSONS(name, gender, age, height, weight) " +
                        "VALUES ('test', 'M', 18, 180, 70)";
        PreparedStatement insertStatement = conection.prepareStatement(sqlInsert);
        insertStatement.execute();

        String sqlParamInsert =
                "INSERT INTO TEST_PERSONS(name, gender, age, height, weight) " +
                        "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertParanStatement = conection.prepareStatement(sqlParamInsert);
        insertParanStatement.setString(1, "test_2");
        insertParanStatement.setString(2, "F");
        insertParanStatement.setInt(3, 18);
        insertParanStatement.setInt(4, 170);
        insertParanStatement.setInt(5, 50);

        insertParanStatement.execute();

        String sqlSelect = "SELECT count(*) as count_row FROM TEST_PERSONS";
        PreparedStatement selectStatement = conection.prepareStatement(sqlSelect);
        ResultSet resultSet = selectStatement.executeQuery();// the reason it returns cursor is that there are GBs of data; it might crash the program
        while (resultSet.next()) {
            System.out.println(resultSet.getString("count_row"));
        }
        conection.close(); // Need to close the connection to manage resources, the connection might get expired or exceed max limit of connection
    }
}
