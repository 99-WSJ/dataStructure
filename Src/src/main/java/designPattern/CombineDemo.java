package designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Src
 * @description: 组合模式
 *
 * 组合模式是⼀种结构型设计模式，
 * 它将对象组合成树状结构来表示“部分-整体”的层次关系。
 * 组合模式使得客户端可以统⼀处理单个对象和对象的组合，
 * ⽽⽆需区分它们的具体类型
 *
 * @author: wsj
 * @create: 2024-07-16 14:57
 **/

interface Component {
    void operation();
}

class Leaf implements Component {

    @Override
    public void operation() {
        System.out.println("leaf========");
    }
}

// 组合节点：包含叶⼦节点的操作⾏为
class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    public void add(Component component) {
        components.add(component);
    }
    public void remove(Component component) {
        components.remove(component);
    }
    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Component component : components) {
            component.operation();
        }
    }
}


public class CombineDemo {
    public static void main(String[] args) {
        // 创建叶⼦节点
        Leaf leaf = new Leaf();
        // 创建组合节点，并添加叶⼦节点
        Composite composite = new Composite();
        composite.add(leaf);
        composite.operation(); // 统⼀调⽤
    }
}
