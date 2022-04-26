package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/26 23:31
 *
 * new ThreadDemo();
 * 分为三步
 * 1.分配内存地址
 * 2.实例化对象
 * 3.讲内存地址复制给对象
 *
 *
 */
public class ThreadDemo {
   public static ThreadDemo threadDemo = null;
   public static void main(String[] args) {
      //多线程情况下 此时会发生指令重排问题 DCL  double check lock 问题
      // 导致对象未实例化完成就分配了地址，导致空指针异常
      if (threadDemo == null){
         synchronized (threadDemo){
            if (threadDemo == null){
               threadDemo = new ThreadDemo();
            }
         }
      }
   }
}
