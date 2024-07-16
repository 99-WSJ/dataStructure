package designPattern;

/**
 * @program: Src
 * @description: 原型模式
 * 创建⼀个抽象类或接⼝，声明⼀个克隆⽅法clone
 * 实现具体原型类，重写克隆⽅法
 * 客户端中实例化具体原型类的对象，并调⽤其克隆⽅法来创建新的对象
 *
 * 相⽐于直接实例化对象，通过原型模式复制对象可以减少资源消耗，提⾼性能
 * 在克隆对象的时候还可以动态地添加或删除原型对象的属性
 * 创造出相似但不完全相同的对象，提⾼了灵活性
 *
 * 需要注意的是：深拷贝情况下引用类型变量的的复制
 *
 * @author: wsj
 * @create: 2024-07-16 13:45
 **/

// 定义抽象原型类或者接口，声明一个clone方法
interface Prototype {
    Prototype clone();
}
// 2. 创建具体原型类
class ConcretePrototype implements Prototype {
    private String data;
    public ConcretePrototype(String data) {
        this.data = data;
    }
    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.data);
    }
    public String getData() {
        return data;
    }
}


public class PrototypeDemo {
    public static void main(String[] args) {
        // 创建原型对象
        Prototype original = new ConcretePrototype("Original Data");
        // 克隆原型对象
        Prototype clone = original.clone();
        // 输出克隆对象的数据
        System.out.println(((ConcretePrototype) clone).getData());
    }
}
