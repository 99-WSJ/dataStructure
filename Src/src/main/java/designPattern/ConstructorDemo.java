package designPattern;

/**
 * @program: Src
 * @description: 建造者模式
 * 使⽤建造者模式可以将⼀个复杂对象的构建与其表示分离，
 * 通过将构建复杂对象的过程抽象出来，可以使客户端代码与具体的构建过程解耦
 * 同样的构建过程可以创建不同的表示，可以有多个具体的建造者(相互独⽴），
 * 可以更加灵活地创建不同组合的对象。
 * @author: wsj
 * @create: 2024-07-16 02:56
 **/

// 产品类
class Product{
    private String part1;
    private String part2;

    public void setPart1(String part1){
        this.part1 = part1;
    }
    public void setPart2(String part2) {
        this.part2 = part2;
    }
}

// 抽象建造者接⼝
interface Builder{
    void buildPart1(String part1);
    void buildPart2(String part2);
    Product getResult();
}

// 具体建造者类
class ConcreteBuilder implements Builder {
    private Product product = new Product();


    @Override
    public void buildPart1(String part1) {
        product.setPart1(part1);
    }

    @Override
    public void buildPart2(String part2) {
        product.setPart2(part2);
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// 指导者类
class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    // 调用方法构建产品
    public void construct() {
        builder.buildPart1("part1");
        builder.buildPart2("part2");
    }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        // 创建具体建造者
        Builder builder = new ConcreteBuilder();
        // 创建指导者
        Director director = new Director(builder);
        // 指导者构建产品
        director.construct();
        // 获取构建好的产品
        Product result = builder.getResult();
        // 输出产品信息
        System.out.println(result);
    }
}
