package designPattern;

public class DecoratorDemo {
    public static void main(String[] args) {
        // 创建具体组件
        Component concreteComponent = new ConcreteComponent();
        // 使⽤具体装饰者包装具体组件
        Decorator decorator = new ConcreteDecorator(concreteComponent);
        // 调⽤操作
        decorator.operation();
    }
}

// 组件接⼝
interface Component {
    void operation();
}

// 具体组件
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}

// 定义⼀个抽象的装饰者类，继承⾃Component
abstract class Decorator implements Component {
    protected Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}

// 具体的装饰者实现
// 如果只有一个接口和实现类，要增加新的功能的时候需要改动原代码，现在使用装饰器可以增加新的功能；
// 装饰器广泛用于JAVA　IO

// 装饰模式通常在以下⼏种情况使⽤：
// 当需要给⼀个现有类添加附加功能，但由于某些原因不能使⽤继承来⽣成⼦类进⾏扩充时，可以使⽤装饰模式。
// 动态的添加和覆盖功能：当对象的功能要求可以动态地添加，也可以再动态地撤销时可以使⽤装饰模式。
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    // 根据需要添加额外的⽅法
    @Override
    public void operation() {
        // 可以在调⽤前后添加额外的⾏为
        System.out.println("Before operation in ConcreteDecorator");
        super.operation();
        System.out.println("After operation in ConcreteDecorator");
    }
}
