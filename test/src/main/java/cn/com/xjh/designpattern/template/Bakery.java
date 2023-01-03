package cn.com.xjh.designpattern.template;

public abstract class Bakery {

    public final void makeBread() {
        // 面团制作步骤
        mixIngredients();
        kneadDough();
        letDoughRise();
        shapeDough();

        // 烤制步骤
        preheatOven();
        bake();
        cool();
    }

    // 具体步骤由子类实现
    abstract void mixIngredients();
    abstract void kneadDough();
    abstract void letDoughRise();
    abstract void shapeDough();
    abstract void addToppings();

    // 模板方法中的步骤
    void preheatOven() {
        // 预热烤箱
        System.out.println("预热烤箱");
    }
    void bake() {
        // 烤制面包
        System.out.println("烤制面包");
    }
    void cool() {
        // 冷却面包
        System.out.println("冷却面包");
    }


}
