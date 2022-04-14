package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 13:32
 * 除了枚举类，其他单例方式会被反序列化破坏单例，通过.class文件反射读进内存 使用反射获取类的Class对象
 */
public enum ENUMSingleton {
    //枚举实例
    INSTANCE;
    public void whateverMethod(){
        System.out.println("whateverMethod");
    }
}
