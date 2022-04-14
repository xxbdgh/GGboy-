package cn.com.xjh;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author xujiahui
 * @create 2022/4/14 13:59
 */
public class Main {
    public static void main(String[] args) {
        //加载配置文件
        Properties properties = new Properties();
        Comparator comparator = null;
        try {
            properties.load(Main.class.getClassLoader().getResourceAsStream("data.properties"));
            String sortType = properties.getProperty("sortType");
            comparator = (Comparator)Class.forName(properties.getProperty(sortType)).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        Cat [] cats = new Cat[]{new Cat(5,5),new Cat(2,2),new Cat(3,3)};
        Sorter<Cat> catSorter = new Sorter<>();
        catSorter.sort(cats,comparator);
        System.out.println(Arrays.toString(cats));
    }

}
