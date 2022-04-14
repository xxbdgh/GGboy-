package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 13:57
 */
public class Cat implements Comparable {
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Object c){
        Cat cat = (Cat)c;
        if(this.weight>cat.weight){
            return 1;
        }else if(this.weight<cat.weight){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
            "weight=" + weight +
            ", height=" + height +
            '}';
    }
}
