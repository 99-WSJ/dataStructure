package designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Src
 * @description: 观察者模式
 *
 * 观察者模式也叫发布-订阅模式
 * 定义了⼀种⼀对多的依赖关系，让多个观察者对象同时监听⼀个主题对象，
 * 当主题对象的状态发⽣变化时，所有依赖于它的观察者都得到通知
 * 并被⾃动更新。
 *
 * @author: wsj
 * @create: 2024-07-17 20:00
 **/

interface Subject{
    // 注册观察者
    void registerObserve(Observe observe);
    // 移除观察者
    void removeObserve(Observe observe);
    // 通知观察者
    void notifyObserve();
}

interface Observe{
    // 更新方法
    void update(String message);
}

class ConcreteSubject implements Subject {
    // 观察者列表
    private List<Observe> observes = new ArrayList<>();
    // 状态
    private String state;

    @Override
    public void registerObserve(Observe observe) {
        observes.add(observe);
    }

    @Override
    public void removeObserve(Observe observe) {
        observes.remove(observe);
    }

    @Override
    public void notifyObserve() {
        observes.forEach(observe -> observe.update(state));
    }

    public void setState(String state) {
        this.state = state;
        notifyObserve();
    }
}

class ConcreteObserve implements Observe {

    @Override
    public void update(String message) {
        System.out.println("update======");
    }
}

public class ObserveDemo {
}
