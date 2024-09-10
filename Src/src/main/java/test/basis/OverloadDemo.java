package test.basis;

public class OverloadDemo {
    public static void main(String[] args){
        A a1;
        A c = new C();
        c.fun();
        //因为c为A类型,所以可以调用fun(),但是在运行时,c肯定是调用自身的fun(),
        // 又因为c中fun()为protcted修饰,B和C又不在同一个包下,所以C中fun()只能由其子类调用,
        // 所以会出现问题
    }
}
/**
 *假设A,B,C三个类都不在相同的包下,并且假设以下编辑器不会报错
 */
class A{
    public A() {
        System.out.println("A的构造方法");
    }
    public void fun() {
        System.out.println("A");
    }
}
class C extends A{
    public C() {
        System.out.println("C的构造方法");
    }
    @Override
    public void fun() {//假设这里编译可以通过
        System.out.println("C");
    }

}
