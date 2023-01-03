package cn.com.xjh.designpattern.template;

public class BaLiXiangBakery extends Bakery {
    @Override
    void mixIngredients() {
        System.out.println("巴黎香混合物制作步骤");
    }

    @Override
    void kneadDough() {
        System.out.println("巴黎香揉面团制作步骤");
    }

    @Override
    void letDoughRise() {
        System.out.println("巴黎香面团发酵制作步骤");
    }

    @Override
    void shapeDough() {
        System.out.println("巴黎香面团造型制作步骤");
    }

    @Override
    void addToppings() {
        System.out.println("巴黎香面包添加配料制作步骤");
    }
}
