package cn.com.xjh.test;

import cn.com.xjh.test.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtils {
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if(con==null) {//说明当前线程尚未加入连接对象，需要获取连接对象赋值
            tl.set(DruidUtils.getConnection());
            return tl.get();
        }else {
            return con;
        }
    }
    /**
     * 开启事务
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        getConnection().setAutoCommit(false);;
    }
    /**
     * 提交事务
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        getConnection().commit();
    }
    /**
     * 回滚事务
     * @throws SQLException
     */
    public static void rollBackTransaction() throws SQLException {
        getConnection().rollback();
    }
    /**
     * 关闭连接
     * @throws SQLException
     */
    public static void close() throws SQLException{
        getConnection().close();
    }
}
