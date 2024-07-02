package handwrite;


/**
 * @program: Src
 * @description: 单例模式
 * @author: wsj
 * @create: 2024-07-01 20:04
 **/
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton  getInstance() {
        return instance;
    }

    private static Singleton instance1;
    public static synchronized Singleton getInstance1() {
        if(instance1 == null) {
            instance1 = new Singleton();
        }
        return instance1;

    }

    private static volatile Singleton instance2;
    public static Singleton getInstance2() {
        if(instance2 == null) {
            synchronized (Singleton.class) {
                if(instance2 == null) {
                    instance2 = new Singleton();
                }
            }
        }
        return instance2;
    }

}


