package cn.com.xjh.designpattern.abstractfactory;


public abstract class ShapeAbstractFactory {

    private String color;

    public abstract Shape getShape(String shapeType);

    public String getColor(){
        return this.color;
    }

    public ShapeAbstractFactory(String color){
        this.color = color;
    }

    public void checkColor(){
        System.out.println("color is " + this.color);
    }

}
