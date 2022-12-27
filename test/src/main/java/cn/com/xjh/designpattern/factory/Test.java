package cn.com.xjh.designpattern.factory;

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(ShapeConstant.TRIANGLE);
        System.out.println(shape.getShape());
        Shape shape1 = shapeFactory.getShape(ShapeConstant.SQUARE);
        System.out.println(shape1.getShape());
    }
}
