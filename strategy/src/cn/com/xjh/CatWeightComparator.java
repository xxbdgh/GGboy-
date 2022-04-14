package cn.com.xjh;




/**
 * @author xujiahui
 * @create 2022/4/14 14:30
 */
public class CatWeightComparator implements Comparator<Cat> {

    @Override
    public int compareTo(Cat o1, Cat o2) {
        if (o1.getWeight() > o2.getWeight()) {
            return 1;
        }
        if (o1.getWeight() < o2.getWeight()) {
            return -1;
        }
        return 0;
    }
}
