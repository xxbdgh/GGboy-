package cn.com.xjh.test;

public interface AccountDao {

    int queryMoney(int id);
    int update(int id,int money);
}
