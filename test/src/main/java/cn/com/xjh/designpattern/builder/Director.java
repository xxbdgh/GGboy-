package cn.com.xjh.designpattern.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildHair();
        builder.buildXBW();
    }

}
