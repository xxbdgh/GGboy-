package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 14:09
 */
public interface Comparable<T> {

    /**
     * 比较两个对象的大小
     * @param obj 要比较的对象
     * @return
     */
    int compareTo(T obj);
}
