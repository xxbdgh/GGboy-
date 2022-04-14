package cn.com.xjh;


import java.io.IOException;
import java.util.Properties;

/**
 * @author xujiahui
 * @create 2022/4/14 19:34
 */
public class Main {

    private static final Properties PROPERTIES = new Properties();

    private static final String CLASSNAME = "NAME";

    private static Class<?> aClass1 = null;
    static {
        try {
            PROPERTIES.load(ClassLoader.getSystemResourceAsStream("data.properties"));
            String property = PROPERTIES.getProperty(CLASSNAME);
            aClass1 = Class.forName(property);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        AbstractFactory abstractFactory = (AbstractFactory) aClass1.newInstance();
        Animal animal = abstractFactory.createAnimal();
        Vehicle vehicle = abstractFactory.createVehicle();
        animal.eat();
        vehicle.go();
    }
}
