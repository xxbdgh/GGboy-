package cn.com.xjh;

import java.util.Arrays;

/**
 * @author xujiahui
 * @create 2022/4/14 13:59
 */
public class Main {
    public static void main(String[] args) {
        Cat [] cats = new Cat[]{new Cat(5,5),new Cat(2,2),new Cat(3,3)};
        Sorter<Cat> catSorter = new Sorter<>();
        catSorter.sort(cats,new CatWeightComparator());
        System.out.println(Arrays.toString(cats));
    }

}
