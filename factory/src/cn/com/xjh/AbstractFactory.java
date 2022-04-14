package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 20:39
 */
public abstract class AbstractFactory {

    /**
     * 创建宠物
     * @return 返回宠物
     */
    abstract Animal createAnimal();

    /**
     * 创建交通工具
     * @return 返回交通工具
     */
    abstract Vehicle createVehicle();


}
