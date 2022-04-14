package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 14:09
 */
public interface Comparator<T> {

    /**
     * 比较两个对象的大小
     * @param o1 要比较的对象
     * @param o2 要比较的对象
     * @return
     */
    int compareTo(T o1, T o2);
}
