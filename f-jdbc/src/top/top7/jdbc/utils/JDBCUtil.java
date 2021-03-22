package top.top7.jdbc.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/22 13:49.
 *
 * ********************************
 *
 * @author top234
 */
public class JDBCUtil {
    private static String url;
    private static String user;
    private static String pass;

    /**
     * 注册驱动
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        pass = bundle.getString("pass");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url,user,pass);
        return connection;
    }

    /**
     * 关闭资源
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
