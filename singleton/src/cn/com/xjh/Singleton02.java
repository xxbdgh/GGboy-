package cn.com.xjh;

import cn.com.constant.Constant;

import java.util.concurrent.*;

/**
 * @author xujiahui
 * @create 2022/4/13 23:26
 * �̰߳�ȫ�ĵ���ģʽ
 */
public class Singleton02 {

    private static Singleton02 INSTANCE;

    public Singleton02() {
    }

    public static Singleton02 getInstance(){
        //��Ҫ��������ӣ�������˷ѻ�ȡ����Դ��һ��
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
        //���̵߳���һ�ٴλ�ȡ��������
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
