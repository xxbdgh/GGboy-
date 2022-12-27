package cn.com.xjh.designpattern.builder;

public class DoubleElevenBuilder extends Builder {

    protected HairRefrigerator hairRefrigerator = new HairRefrigerator();
    protected XBWRefrigerator xbwRefrigerator = new XBWRefrigerator();


    @Override
    public void buildHair() {
        hairRefrigerator.setName("海尔冰箱");
        hairRefrigerator.setPrice(1000);
        hairRefrigerator.setDesc("双十一活动爽翻天");
    }

    @Override
    public void buildXBW() {
        xbwRefrigerator.setName("小霸王冰箱");
        xbwRefrigerator.setPrice(2050);
        xbwRefrigerator.setDesc("双十一活动惊喜连连");
    }

    @Override
    public Refrigerator getRefrigerator(String type) {
        if (type.equals(RefrigeratorType.HAIR)) {
            return hairRefrigerator;
        } else if (type.equals(RefrigeratorType.XBW)) {
            return xbwRefrigerator;
        }
        return null;
    }

    @Override
    void updateDescByPriceLess(Integer priceLess) {
        if (hairRefrigerator.getPrice() < priceLess) {
            hairRefrigerator.setDesc("双十一活动爽翻天，价格低于" + priceLess);
            hairRefrigerator.setTitle("低价");
        }
        if (xbwRefrigerator.getPrice() < priceLess) {
            xbwRefrigerator.setDesc("双十一活动惊喜连连，价格低于" + priceLess);
            xbwRefrigerator.setTitle("低价");
        }
    }
}
