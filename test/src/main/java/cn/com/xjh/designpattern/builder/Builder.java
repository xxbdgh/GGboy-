package cn.com.xjh.designpattern.builder;

public abstract class Builder {

    abstract void buildHair();

    abstract void buildXBW();

    abstract void updateDescByPriceLess(Integer priceLess);

    abstract Refrigerator getRefrigerator(String type);


}
