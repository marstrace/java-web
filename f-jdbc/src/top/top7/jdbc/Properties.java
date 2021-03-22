package top.top7.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/22 13:44.
 *
 * ********************************
 *
 * @author top234
 *
 * 使用资源绑定器绑定属性配置文件
 */
public class Properties {
    private static String driver;
    private static String url;
    private static String user;
    private static String pass;


    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        pass = bundle.getString("pass");
    }

    public static void main(String[] args) {
        try{
            System.out.println("我是1");
            return;
        }catch (Exception e){
            System.out.println("我是2");
            e.printStackTrace();
            return;
        }finally {
            System.out.println("我是3");
            return;
        }
    }

    /**
     * preparedStatement
     */
    private static void testPreparedStatement() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            String s = "select * from video where vname like ? ";
            ps = connection.prepareStatement(s);
            ps.setString(1, "%jdbc%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("daynum"));
                System.out.println(resultSet.getString("vname"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private static void selectVideo() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from video where vname like '%jdbc%'");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") + "\t");
                System.out.print(resultSet.getString("daynum") + "\t");
                System.out.println(resultSet.getString("vname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
