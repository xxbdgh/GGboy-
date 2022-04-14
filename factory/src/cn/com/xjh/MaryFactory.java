package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 20:39
 */
public class MaryFactory extends AbstractFactory {


    @Override
    Animal createAnimal() {
        return new Dog();
    }

    @Override
    Vehicle createVehicle() {
        return new Plane();
    }
}
