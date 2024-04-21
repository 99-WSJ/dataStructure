package test;

/**
 * @author wsj
 * @description
 * @date 2024年04月21日 14:01
 */
 class TestA {
    private Integer a;
    public Integer getA() {
        return a;
    }
    public void setA(Integer a) {
        this.a = a;
    }
}
public class test {
    public static void main(String[] args) {
        TestA a = new TestA();
        a.setA(1);
        TestA aa = a;
        System.out.println(aa==a);
        a.setA(3);
        System.out.println(aa==a);
        System.out.println(aa.getA());
    }
}

