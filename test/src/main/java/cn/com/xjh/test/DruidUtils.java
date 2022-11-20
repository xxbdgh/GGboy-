package cn.com.xjh.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.core.serializer.Serializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid连接池工具类
 * 使用Druid连接池步骤：
 * 1、导入Druid-maven
 * 2、在项目中新建druid-config.xml配置文件，放在src下
 * 3、使用DruidDataSource类来获取DruidDataSource对象（连接池对象，此处无需手动读取配置文件）
 * 4、使用DataSource对象调用getConnection()方法即可获取到连接池对象
 * @author stone
 *
 */
@Component
public class DruidUtils implements Serializable {
    private static Properties properties;
    private static  DruidUtils druid;
    private static DruidDataSource ds;

    static {
        properties=new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds=new DruidDataSource();
        ds.setDriverClassName(properties.getProperty("driverClassName"));
        ds.setUrl(properties.getProperty("url"));
        ds.setUsername(properties.getProperty("username"));
        ds.setPassword(properties.getProperty("password"));
        ds.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
    }
    /**
     * 创建单列模式
     * @return DruidUtils实例
     */
    public static synchronized DruidUtils getInstance() {
        if(druid==null) {
            druid=new DruidUtils();
            return druid;
        }
        return druid;
    }

    private DruidUtils() {

    }


    public static Connection getConnection() throws SQLException {
        Connection connection = ds.getConnection();
        return connection;
    }
}
