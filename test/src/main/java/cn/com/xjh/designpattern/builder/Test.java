package cn.com.xjh.designpattern.builder;

public class Test {

    public static void main(String[] args) {
        Builder builder = new DoubleElevenBuilder();
        new Director(builder).construct();
        builder.updateDescByPriceLess(1000);
        Refrigerator refrigerator = builder.getRefrigerator(RefrigeratorType.XBW);
        System.out.println(refrigerator.getDetail());
    }
}
