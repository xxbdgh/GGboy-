package cn.com.xjh.designpattern.abstractfactory;

public class ShapeFactory extends ShapeAbstractFactory {


    public ShapeFactory(String color) {
        super(color);
    }

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("Triangle")) {
            return new Triangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
