package designPattern;

/**
 * @program: Src
 * @description: 策略模式
 * @author: wsj
 * @create: 2024-09-10 14:36
 **/
public class StrategyDemo {
    public static void main(String[] args) {
        // 七折计算
        Strategy strategy = new StrategyA();
        Context context = new Context(strategy);
        context.contextInterface();
        // 五折计算
        Strategy strategy1 = new StrategyB();
        Context context1 = new Context(strategy1);
        context1.contextInterface();
    }
}

interface Strategy {
    void func();
}

class StrategyA implements Strategy {

    @Override
    public void func() {
        System.out.println("七折");
    }
}

class StrategyB implements Strategy {

    @Override
    public void func() {
        System.out.println("五折");
    }
}

class Context {
    private Strategy strategy;

    // 设置具体的策略
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    // 执⾏策略
    public void contextInterface() {
        strategy.func();
    }
}