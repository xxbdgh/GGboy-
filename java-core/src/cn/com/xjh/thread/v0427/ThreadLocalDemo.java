package cn.com.xjh.thread.v0427;

/**
 * @author xujiahui
 * @create 2022/4/27 0:04
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        /**
         * ThreadLocal是线程包中的一个类，它可以让我们在线程中存储数据，
         * 并且所有线程的数据互不影响，保证了数据的可见性和安全性。
         */
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    }
}
