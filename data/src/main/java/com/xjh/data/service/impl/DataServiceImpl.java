package com.xjh.data.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xjh.data.entity.DataBase;
import com.xjh.data.service.DataService;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author xujiahui
 * @create 2022/4/28 15:19
 */
@Service
public class DataServiceImpl implements DataService {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("db/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };


    private static DataBase primaryDataBase;

    private static DataBase targetDataBase;

    @Override
    public HashMap<String , ArrayList<String>> getDataTable(String primaryName, String targetName) {
        createPrimaryData(primaryName);
        HashMap<String , ArrayList<String>> map = new HashMap();
        try {
            DatabaseMetaData dbmd = primaryDataBase.getCon().getMetaData();
            //所有的表名称
            ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
            String tableName = "";
            while (tableRet.next()) {
                ArrayList list = new ArrayList();
                //所有的列
                tableName = tableRet.getString("TABLE_NAME");
                if (!tableName.equals("sys_config")){
                    ResultSet colRet = dbmd.getColumns(null, "%", tableName, "%");
                    while (colRet.next()) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put()
                        list.add(colRet.getString("COLUMN_NAME") + "_"
                            + colRet.getString("TYPE_NAME"));
                    }
                    map.put(tableName, list);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            primaryDataBase.closeConnection();
        }
        return map;
    }

    private void createPrimaryData(String primaryName) {
        primaryDataBase = new DataBase(properties.getProperty(primaryName+".driver"),
            properties.getProperty(primaryName+".username"),
            properties.getProperty(primaryName+".password"),
            properties.getProperty(primaryName+".url"));
    }

    private void createTargetData(String targetName) {
        targetDataBase = new DataBase();
        targetDataBase.setDriveName(properties.getProperty(targetName+".driver"));
        targetDataBase.setUserName(properties.getProperty(targetName+".username"));
        targetDataBase.setPassword(properties.getProperty(targetName+".password"));
        targetDataBase.setUrl(properties.getProperty(targetName+".url"));
    }
}
