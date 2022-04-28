package com.xjh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xujiahui
 * @create 2022/4/28 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataBase {

    private String driveName = null;
    private String userName = null;
    private String password = null;
    private String url = null;
    private Connection con = null;

    public DataBase(String driveName, String userName, String password, String url) {
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

    /**
     *关闭
     *
     */
    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }            con = null;
        }
    }

}
