package designPattern;

/**
 * 一个组件接口、2个具体组件（n）
 * 一个抽象装饰类，2个具体装饰类（n）
 * @author 阿叙
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        // 创建具体组件
        Coffee bcoffee = new BlackCoffee();
        // 使⽤具体装饰者包装具体组件
        Decorator decorator = new MilkDecorator(bcoffee);
        // 调⽤操作
        decorator.brew();
    }
}

// 咖啡接⼝
interface Coffee {
    void brew();
}

// 具体的⿊咖啡类
class BlackCoffee implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing Black Coffee");
    }
}
// 具体的拿铁类
class Latte implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing Latte");
    }
}
// 装饰者抽象类
abstract class Decorator implements Coffee {
    protected Coffee coffee;
    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public void brew() {
        coffee.brew();
    }
}



// 具体的装饰者实现
// 如果只有一个接口和实现类，要增加新的功能的时候需要改动原代码，现在使用装饰器可以增加新的功能；
// 装饰器广泛用于JAVA　IO

// 装饰模式通常在以下⼏种情况使⽤：
// 当需要给⼀个现有类添加附加功能，但由于某些原因不能使⽤继承来⽣成⼦类进⾏扩充时，可以使⽤装饰模式。
// 动态的添加和覆盖功能：当对象的功能要求可以动态地添加，也可以再动态地撤销时可以使⽤装饰模式。

// 具体的⽜奶装饰者类
class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public void brew() {
        super.brew();
        System.out.println("Adding Milk");
    }
}
// 具体的糖装饰者类
class SugarDecorator extends Decorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public void brew() {
        super.brew();
        System.out.println("Adding Sugar");
    }
}
