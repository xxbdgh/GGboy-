package cn.com.xjh.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class SixOneEightShoppingBuilder extends Builder {

    private HairRefrigerator hairRefrigerator = new HairRefrigerator();
    private XBWRefrigerator xbwRefrigerator = new XBWRefrigerator();

    @Override
    public void buildHair() {
        hairRefrigerator.setName("海尔冰箱");
        hairRefrigerator.setPrice(1000);
        hairRefrigerator.setDesc("618狂欢活动");
    }

    @Override
    public void buildXBW() {
        xbwRefrigerator.setName("小霸王游戏机");
        xbwRefrigerator.setPrice(200);
        xbwRefrigerator.setDesc("618狂欢活动惊喜连连");
    }

    @Override
    void updateDescByPriceLess(Integer priceLess) {
        if (hairRefrigerator.getPrice() < priceLess) {
            hairRefrigerator.setDesc("618狂欢活动，价格低于" + priceLess);
            hairRefrigerator.setTitle("低价");
        }
        if (xbwRefrigerator.getPrice() < priceLess) {
            xbwRefrigerator.setDesc("618狂欢活动惊喜连连，价格低于" + priceLess);
            xbwRefrigerator.setTitle("低价");
        }
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

}
