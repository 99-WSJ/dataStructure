package test.basis;

public class FinalDemo {

    public static void main(String[] args) {
        //System.out.println(testFinally());
        System.out.println(test());
    }
    public static String test() {
        String s = null;
        try {
            System.out.println("我是try里面的语句");
            System.out.println(s.length());
            return "我是try里的return语句";
        } catch (NullPointerException e) {
            System.out.println("我是catch语句里面语句1");
            return "我是catch语句里面的return语句1";
        } catch (Exception e) {
            System.out.println("我是catch语句里面语句2");
            return "我是catch语句里面的return语句2";
        } finally {
            System.out.println("我是finally里面的执行语句");
            return "我是finally里面的return语句";
        }
    }

    public static int testFinally() {
        try {
            // 在try块中有return语句
            System.out.println("try");
            return 1;
        } catch (Exception e) {
            // 这里的catch块不会执行，因为try块中没有抛出异常
            System.out.println("Catch block");
        } finally {
            // finally块总是会执行
            // finally中最好不要包含 return，否则程序会提前退出
            System.out.println("Finally block");
            return -1;
        }
    }


}
