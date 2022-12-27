package cn.com.xjh.designpattern.builder;

public class HairRefrigerator implements Refrigerator {

    private String name;

    private Integer price;

    private String desc;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDetail() {
        return "name:" + this.name + ",price:" + this.price + ",desc:" + this.desc + ",title:" + this.title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }
}
