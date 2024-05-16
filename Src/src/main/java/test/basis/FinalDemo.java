package test.basis;

public class FinalDemo {

    public static void main(String[] args) {
        System.out.println(testFinally());
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
