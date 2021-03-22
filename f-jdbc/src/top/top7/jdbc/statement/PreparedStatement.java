package top.top7.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/22 13:43.
 *
 * ********************************
 *
 * @author top234
 *
 * JDBC 使用流程之preparedStatement
 */
public class PreparedStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/study";
        Connection connection = null;
        java.sql.PreparedStatement statement = null;

        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接
            connection = DriverManager.getConnection(url, "root", "password");
            //3.获取预编译操作对象
            statement = connection.prepareStatement("insert into topres values(4,'hh',25,'python')");
            //4.执行sql
            int i = statement.executeUpdate();
            System.out.println(i == 1 ? "操作成功" : "操作失败");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
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

                        }
                    }
                }
            }
        }
    }
}
