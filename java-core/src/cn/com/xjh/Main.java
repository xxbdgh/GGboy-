package cn.com.xjh;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author xujiahui
 * @create 2022/4/16 13:36
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //获取类对象的四种方式
        //1.通过类名获取类对象
        Class<Demo> clazz1 = Demo.class;
        //2.通过Class.forName(全类名)
        Class<?> clazz2 = Class.forName("cn.com.xjh.Demo");
        //3.通过反射机制获取类对象
        Class<?> clazz3 = new Demo().getClass();
        //4.通过类加载器获取类对象
        Class<?> clazz4 = Demo.class.getClassLoader().loadClass("cn.com.xjh.Demo");

        //获取类的属性
        //获取类的修饰符 private 2 public 1 final 16 abstract 1024
        System.out.println(clazz1.getModifiers());
        //获取包
        System.out.println(clazz1.getPackage());
        //获取类名
        System.out.println(clazz1.getName());
        //获取父类
        System.out.println(clazz1.getSuperclass());
        //获取接口类似实现的所有接口
        System.out.println( clazz1.getInterfaces());
        //获取类加载器
        System.out.println( clazz1.getClassLoader());
        //获取方法
        System.out.println(clazz1.getSimpleName());
        //获取具体信息
        System.out.println(clazz1.getAnnotatedInterfaces());
        Field nameFiled = clazz1.getDeclaredField("name");
        nameFiled.setAccessible(true);

    }
}
