package designPattern;

/**
 * @program: Src
 * @description: 抽象工厂模式
 * 抽象产品、具体产品
 * 抽象工厂、具体工厂
 *
 * 相比于 工厂方法，抽象工厂多了一个抽象接口和两个具体产品实现类
 * @author: wsj
 * @create: 2024-07-16 02:27
 **/

interface ShapeA{
    void drawA();
}

interface ShapeB{
    void drawB();
}

class CircleA implements ShapeA{

    @Override
    public void drawA() {
        System.out.println("draw circle AAAAA");
    }
}

class SquareA implements ShapeA{

    @Override
    public void drawA() {
        System.out.println("draw square AAAAAA");
    }
}

class CircleB implements ShapeB{

    @Override
    public void drawB() {
        System.out.println("draw circle BBB");
    }
}

class SquareB implements ShapeB{

    @Override
    public void drawB() {
        System.out.println("draw square BBB");
    }
}

interface AbstractFactory {
    ShapeA setShapeA();
    ShapeB setShapeB();
}

class CircleAbstractFactory implements AbstractFactory{


    @Override
    public ShapeA setShapeA() {
        return new CircleA();
    }

    @Override
    public ShapeB setShapeB() {
        return new CircleB();
    }
}

class SquareAbstractFactory implements AbstractFactory{


    @Override
    public ShapeA setShapeA() {
        return new SquareA();
    }

    @Override
    public ShapeB setShapeB() {
        return new SquareB();
    }
}


public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory c = new CircleAbstractFactory();
        ShapeA cirA = c.setShapeA();
        ShapeB cirB = c.setShapeB();
        cirA.drawA();
        cirB.drawB();
    }
}
