package cn.com.xjh.test.service;

import cn.com.xjh.test.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;
    @Override
    public void transfer(int fromId, int destId, int money) throws SQLException {
        //将开启事务和关闭事务的代码放到aop中
        //TransactionUtils.startTransaction();
        int fromMoney = accountDao.queryMoney(fromId) - money;
        int destMoney = accountDao.queryMoney(destId) + money;

        accountDao.update(fromId,fromMoney);
        //制造异常
        //int i = 1/0;
        accountDao.update(destId,destMoney);

        //TransactionUtils.commitTransaction();

    }
}
