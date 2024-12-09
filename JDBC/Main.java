package JDBC;

import java.sql.*;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/test";
    static String username = "root";
    static String  password = "yourpassword";

    public static void main(String[] args) throws SQLException {
        insertData();
        showData();
    }

    public static Connection sqlConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void insertData() throws SQLException {
        Connection connection = sqlConnection();

        String sqlData1 = "create table if not exists javaTable (" +
                "id int primary key auto_increment," +
                "name varchar(255) not null," +
                "email varchar(255) not null unique" +
                ")";
        //String sqlData2 = "insert into javaTable (name, email) values('alex', 'alex@gmail.com')";

        PreparedStatement stmt1 = connection.prepareStatement(sqlData1);
        //PreparedStatement stmt2 = connection.prepareStatement(sqlData2);

        stmt1.execute();
        //stmt2.execute();

        stmt1.close();
        //stmt2.close();

        System.out.println("Data inserted successfully to the MySql Database!");
    }

    public static void showData() throws SQLException {
        Connection connection = sqlConnection();

        String sqlData1 = "select * from javaTable";
        PreparedStatement stmt1 = connection.prepareStatement(sqlData1);

        ResultSet resultSet = stmt1.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.printf("name = %s, email = %s\n", name, email);
        }

        resultSet.close();
        connection.close();
        stmt1.close();
    }

}
