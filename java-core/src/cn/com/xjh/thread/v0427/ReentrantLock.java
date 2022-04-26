package cn.com.xjh.thread.v0427;

import java.util.concurrent.locks.Lock;

/**
 * @author xujiahui
 * @create 2022/4/26 23:46
 * 重入锁
 */
public class ReentrantLock {
   /**
    * 重入锁 每一次获取锁会计数+1 不同线程用map保存
    * 避免了内存态与内核态的频繁切换带来的性能消耗，
    * 性能更好
    */
   static Lock lock = new java.util.concurrent.locks.ReentrantLock();
   public static void main(String[] args) {
      try {
         lock.lock();
         System.out.println("获取锁");
      }catch (Exception e){
         e.printStackTrace();
      }finally {
         lock.unlock();
      }
   }
}
