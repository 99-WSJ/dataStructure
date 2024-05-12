package test.testThread;


/**
 * 方式1：继承Thread类的线程实现方式如下：
 * 1.创建一个集成于Thread类的子类 （通过ctrl+o（override）输入run查找run方法）
 * 2.重写Thread类的run（）方法
 * 3.创建Thread子类的对象
 * 4.通过此对象调用start（）方法
 *
 * 创建三个窗口卖票，总票数为100张，使用继承自Thread方式
 * 用静态变量保证三个线程的数据独一份
 *
 * 存在线程的安全问题，有待解决
 *
 *
 * @author 阿叙*/

public class ThreadDemo1{

    public static void main(String[] args){
        window t1 = new window();
        window t2 = new window();
        window t3 = new window();

        t1.setName("售票口1");
        t2.setName("售票口2");
        t3.setName("售票口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class window extends Thread{
    private static int ticket = 100;
    //将其加载在类的静态区，所有线程共享该静态变量

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                                //try {
                                //    sleep(100);
                                //} catch (InterruptedException e) {
                                //    e.printStackTrace();
                                //}
                System.out.println(getName()+"当前售出第"+ticket+"张票");
                ticket--;
            }else{
                break;
            }
        }
    }
}