package cn.com.xjh;

import cn.com.constant.Constant;

import java.util.concurrent.*;

/**
 * @author xujiahui
 * @create 2022/4/13 23:26
 * 线程安全的单例模式
 */
public class Singleton02 {

    private static Singleton02 INSTANCE;

    public Singleton02() {
    }

    public static Singleton02 getInstance(){
        //想要完美必须加，否则会浪费获取锁资源这一步
        if(INSTANCE == null){
            synchronized (Singleton02.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton02();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        //多线程调用一百次获取单例对象
        ExecutorService newExecutorService = Executors.newCachedThreadPool();
        for (int i = 0; i < Constant.CYCLE; i++) {
            newExecutorService.execute(()->{
                System.out.println(Singleton02.getInstance().hashCode());
            });

        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
