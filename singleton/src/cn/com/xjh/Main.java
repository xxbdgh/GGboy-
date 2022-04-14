package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 13:33
 *
 */
public class Main {
   public static void main(String[] args) {
      ENUMSingleton instance = ENUMSingleton.INSTANCE;
      ENUMSingleton instance1 = ENUMSingleton.INSTANCE;
      System.out.println(instance == instance1);
   }
}
