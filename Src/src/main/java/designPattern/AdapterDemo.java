package designPattern;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

/**
 * @author 阿叙
 * 在开发过程中，适配器模式往往扮演者“补救”和“扩展”的⻆⾊：
 * 当使⽤⼀个已经存在的类，但是它的接⼝与你的代码不兼容时，可以使⽤适配器模式。
 * 在系统扩展阶段需要增加新的类时，并且类的接⼝和系统现有的类不⼀致时，可以使⽤适配器模式。
 * 使⽤适配器模式可以将客户端代码与具体的类解耦，客户端不需要知道被适配者的细节，客户端代码也不需要修
 * 改，这使得它具有良好的扩展性，但是这也势必导致系统变得更加复杂。
 */
public class AdapterDemo {
    // 客户端代码
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}

// ⽬标接⼝
interface Target {
    void request();
}

// 被适配者类
class Adaptee {
    void specificRequest() {
        System.out.println("Specific request");
    }
}

// 适配器类
class Adapter implements Target {
    // 持有⼀个被适配者实例
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // 调⽤被适配者类的⽅法
        adaptee.specificRequest();
    }
}
