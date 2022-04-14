package cn.com.xjh;

/**
 * @author xujiahui
 * @create 2022/4/14 14:35
 */
public class Sorter<T> {

    public void sort(T[] t, Comparator<T> comparator) {
        //给T类型数组排序
        for (int i = 0; i < t.length - 1; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if (comparator.compareTo(t[i], t[j]) > 0) {
                    T temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                }
            }
        }

    }
}
