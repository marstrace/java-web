package top.top7.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/22 13:41.
 *
 * ********************************
 *
 * @author top234
 *
 * JDBC 使用流程之 Statement
 */
public class Statement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/study";
        Connection connection = null;
        java.sql.Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.加载驱动
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());//com.mysql.jdbc.Driver的静态块中执行了这行代码
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接
            connection = DriverManager.getConnection(url, "root", "password");
            //3.获取数据库操作对象
            statement = connection.createStatement();
            //4.执行sql语句
            resultSet = statement.executeQuery("select * from topres");

            //5.处理结果集
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");
                System.out.println(resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
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
            }
        }
    }
}
