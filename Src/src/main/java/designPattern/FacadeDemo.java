package designPattern;

import javax.swing.*;

/**
 * @program: Src
 * @description: 外观模式/门面模式
 *
 * 外观模式通过提供⼀个简化的接⼝，隐藏了系统的复杂性，
 * 降低了客户端和⼦系统之间的耦合度，客户端不需要了解系统的内部实现细节，
 * 也不需要直接和多个⼦系统交互，只需要通过外观接⼝与外观对象进⾏交互。
 * 但是如果需要添加新的⼦系统或修改⼦系统的⾏为，就可能需要修改外观类，
 * 这违背了“开闭原则”。
 *
 * @author: wsj
 * @create: 2024-07-16 14:21
 **/

class AirCoonditioner{
    public void turnOff() {
        System.out.println("Air Conditioner is turned off");
    }
}

class DeskLamp{
    public void turnOff() {
        System.out.println("Desk Lamp is turned off");
    }
}

class Television {
    public void turnOff() {
        System.out.println("Television is turned off");
    }
}

class Facade {
    private AirCoonditioner airCoonditioner;
    private DeskLamp deskLamp;
    private Television television;

    public Facade() {
        this.airCoonditioner = new AirCoonditioner();
        this.deskLamp = new DeskLamp();
        this.television = new Television();
    }

    public void operation(int deviceCode) {
        switch (deviceCode) {
            case 1:
                airCoonditioner.turnOff();
                break;
            case 2:
                deskLamp.turnOff();
                break;
            case 3:
                television.turnOff();
                break;
            case 4:
                System.out.println("all devices are off");
                break;
            default:
                System.out.println("Invalid device code");
        }
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operation(1);
    }
}
