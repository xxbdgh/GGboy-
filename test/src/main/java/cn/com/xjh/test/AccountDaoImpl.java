package cn.com.xjh.test;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Override
    public int queryMoney(int id) {
        try {
            QueryRunner queryRunner = new QueryRunner();
            String sql = "select money from test1 where id = ?";
            int query = queryRunner.query(TransactionUtils.getConnection(), sql,new ScalarHandler<>(),id);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(int id, int money) {
        String sql = "update test1 set money = ? where id = ?";
        try {
            int update = new QueryRunner().update(TransactionUtils.getConnection(), sql, money, id);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
