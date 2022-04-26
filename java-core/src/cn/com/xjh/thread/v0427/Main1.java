package cn.com.xjh.thread.v0427;

import java.util.Base64;

/**
 * @author xujiahui
 * @create 2022/4/20 21:18
 */
public class Main1 {
   public volatile static boolean flag = false;

   public static void main(String[] args) throws InterruptedException {
      //创建一个线程循环
      Thread thread = new Thread(()->{
         int i = 0;
         while (!flag){
            i++;
         }
         System.out.println("i="+i);
      });
      thread.start();
      System.out.println("Thread start");
      Thread.sleep(1000);
      flag = true;
   }
}
