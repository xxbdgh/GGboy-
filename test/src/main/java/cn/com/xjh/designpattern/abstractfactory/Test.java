package cn.com.xjh.designpattern.abstractfactory;

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory("红色");
        String color = shapeFactory.getColor();
        shapeFactory.checkColor();
        System.out.println(color);
        Shape shape = shapeFactory.getShape(ShapeConstant.TRIANGLE);
        System.out.println(shape.getShape());
        Shape shape1 = shapeFactory.getShape(ShapeConstant.SQUARE);
        System.out.println(shape1.getShape());
    }
}
