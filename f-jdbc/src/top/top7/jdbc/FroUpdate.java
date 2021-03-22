package top.top7.jdbc;

import top.top7.jdbc.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/22 13:46.
 *
 * ********************************
 *
 * @author top234
 *
 * 行级锁: 悲观锁/排它锁 fro update
 */
public class FroUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select * from t_mytest for update";
        String sql2 = "insert into t_mytest(name,age,work,id) values(?,?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, "张三");
            preparedStatement.setInt(2, 23);
            preparedStatement.setString(3, "java程序员");
            preparedStatement.setInt(4,6);
            int i = preparedStatement.executeUpdate();
            System.out.println(i == 1 ? "插入成功" : "插入失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, null);
        }
    }
}
