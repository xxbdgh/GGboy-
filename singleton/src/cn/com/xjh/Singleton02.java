package cn.com.xjh;

import cn.com.constant.Constant;

import java.util.concurrent.*;

/**
 * @author xujiahui
 * @create 2022/4/13 23:26
 * �̰߳�ȫ�ĵ���ģʽ
 */
public class Singleton02 {

    /**
     * ʹ�����ַ�ʽʹ�õ�������Ҫ����volatile�ؼ��֣���Ϊ��ָ����������
     * ָ������ �� new Singletonʱ����һ��ԭ���Բ��������������������ϲ���һ������
     * 1. ��������ڴ�ռ�
     * 2. ��ʼ������
     * 3. ������ָ�������ڴ�ռ�
     * �������������û�а���˳��ִ�У�����ܳ���ָ�����ŵ�����
     * �����һ������û��ִ���꣬�ڶ��������Ϳ�ʼִ�У��ڶ�������ִ���꣬�����������Ϳ�ʼִ�У�
     * �����Ϳ��ܳ��ֵڶ�������ִ���꣬����������ִ��֮ǰ����һ��������û��ִ��������
     * ����ĳһ�߳� �ж�ʱ��ǰһ��������ָ�����ڴ�ռ䣬��ô�жϵ��ڴ�ռ���Ϊnull��
     * ����ʱ�ͻ᷵��һ����ֵ
     */
    private static volatile Singleton02 INSTANCE;

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
