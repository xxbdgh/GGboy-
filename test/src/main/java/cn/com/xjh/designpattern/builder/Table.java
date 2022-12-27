package cn.com.xjh.designpattern.builder;

public class Table implements Refrigerator {

    private String name;
    private String price;
    private String desc;

    public Table(String name, String price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String getDetail() {
        return "name:" + this.name + ",price:" + this.price + ",desc:" + this.desc;
    }

}
