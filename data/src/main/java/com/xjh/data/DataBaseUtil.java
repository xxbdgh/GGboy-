package com.xjh.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.vendor.Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xujiahui
 * @create 2022/4/27 16:12
 */
public class DataBaseUtil {


    static class DataBase(String diverName,){
        private String driveName = null;
        private String userName = null;
        private String password = null;
        private String url = null;
        private Connection con = null;
        public DataBase(String driveName, String userName, String password,String url) {
            linkDataBase(driveName);
            createConnection(userName, password, url);
        }
        private void linkDataBase(String driveName) {
            try {
                Class.forName(driveName);
            } catch (ClassNotFoundException e) {
                System.out.println("Link DataBase Fail!");
            }
        }
        private void createConnection(String userName, String password, String url) {
            try {
                con = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                System.out.println("Connection Opened Fail!!");
                e.printStackTrace();
            }
        }
    }
}
