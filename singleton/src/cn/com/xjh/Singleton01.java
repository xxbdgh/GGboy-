package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/13 23:13
 * 单例模式 饿汉式
 */
public class Singleton01 {

    private String name;

    private String age;

    private static final Singleton01 INSTANCE = new Singleton01();

    public Singleton01() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01 instance = Singleton01.getInstance();
        instance.setName("xjh");
        Singleton01 instance2 = Singleton01.getInstance();
        instance2.setAge("11");
        System.out.println(instance.getName() + " : " + instance.getAge());
        System.out.println(instance2.getName() + " : " + instance2.getAge());
    }

}
