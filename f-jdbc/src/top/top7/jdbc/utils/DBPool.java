package top.top7.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/22 13:48.
 *
 * ********************************
 *
 * @author top234
 *
 * 数据库连接池之: Druid
 */
public class DBPool {
    public static void main(String[] args) {
        //读取配置文件
        InputStream db = DBPool.class.getResourceAsStream("/db.properties");

        Properties properties = new Properties();
        try {
            //加载配置文件
            properties.load(db);
            //创建数据源
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            //获取数据库连接对象
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            //将数据库连接放回连接池中,这里的close被Druid重写了,作用是将连接放回池中
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
