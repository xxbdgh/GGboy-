package cn.com.xjh;

import cn.com.constant.Constant;

import java.util.concurrent.*;

/**
 * @author xujiahui
 * @create 2022/4/13 23:26
 * 线程安全的单例模式
 */
public class Singleton02 {

    /**
     * 使用这种方式使用单例，需要加上volatile关键字，因为有指令重排问题
     * 指令重排 ： new Singleton时不是一个原子性操作，是由三个操作，合并成一个操作
     * 1. 分配对象内存空间
     * 2. 初始化对象
     * 3. 将对象指向分配的内存空间
     * 如果这三个操作没有按照顺序执行，则可能出现指令重排的问题
     * 如果第一个操作没有执行完，第二个操作就开始执行，第二个操作执行完，第三个操作就开始执行，
     * 这样就可能出现第二个操作执行完，第三个操作执行之前，第一个操作还没有执行完的情况
     * 比如某一线程 判断时，前一个操作先指向了内存空间，那么判断的内存空间则不为null，
     * 返回时就会返回一个空值
     */
    private static volatile Singleton02 INSTANCE;

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
