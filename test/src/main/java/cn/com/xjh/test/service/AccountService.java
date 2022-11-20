package cn.com.xjh.test.service;

import java.sql.SQLException;

public interface AccountService {
    //from 给 destination 转money
    void transfer(int fromId,int destId,int money) throws SQLException;
}
