package designPattern;

import org.apache.xmlbeans.impl.xb.xsdschema.Facet;

import java.net.SocketTimeoutException;

/**
 * @program: Src
 * @description: 工厂方法模式
 * 抽象产品、具体产品
 * 抽象工厂、具体工厂
 * @author: wsj
 * @create: 2024-07-16 02:17
 **/
interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("draw square");
    }
}

interface Factory {
    Shape setShape();
}

class CircleFactory implements Factory{


    @Override
    public Shape setShape() {
        return new Circle();
    }
}

class SquareFactory implements Factory{


    @Override
    public Shape setShape() {
        return new Square();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        Factory circle  = new CircleFactory();
        Shape c = circle.setShape();
        c.draw();


        Factory square  = new SquareFactory();
        Shape s = square.setShape();
        s.draw();
    }
}
