package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 20:05
 */
public class JohnFactory extends AbstractFactory {

    @Override
    Animal createAnimal() {
        return new Cat();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
