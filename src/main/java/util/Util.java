package util;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public static Map<String, String> getUserInfo(int id) throws SQLException {
        Connection connection = PostgreDriverManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("name", resultSet.getString(3));
            userInfo.put("surname", resultSet.getString(4));
            userInfo.put("login", resultSet.getString(2));
            userInfo.put("age", String.valueOf(resultSet.getInt(5)));
            return userInfo;
        } else {
            return null;
        }
    }
    public static boolean changeUserLogin(int id, String newLogin) throws SQLException {
        Connection connection = PostgreDriverManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("update users set login=? where id=?;");
        statement.setInt(2, id);
        statement.setString(1, newLogin);
            return statement.executeUpdate() > 0;
    }
    public static boolean deleteUser(int id) throws SQLException {
        Connection connection = PostgreDriverManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from users where id=?;");
        statement.setInt(1, id);
        return statement.executeUpdate() > 0;
    }
    public static boolean createUser(String name, String surname, String login, int age) throws SQLException {
        Connection connection = PostgreDriverManager.getInstance().getConnection();
        PreparedStatement statement = connection.
                prepareStatement("insert into users (login, name, surname, age) values (?, ?, ?, ?);");
        statement.setString(1, login);
        statement.setString(2, name);
        statement.setString(3, surname);
        statement.setInt(4, age);
        return statement.executeUpdate() > 0;
    }
}
