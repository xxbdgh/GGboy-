package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 13:57
 */
public class Cat {
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
            "weight=" + weight +
            ", height=" + height +
            '}';
    }
}
