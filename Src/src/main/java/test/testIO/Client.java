package test.testIO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * BIO:同步阻塞IO
 *
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.创建Socket对象请求服务端的连接
            Socket socket = new Socket("127.0.0.1",9999);
            //2.从Socket对象中获取一个字节输出流
            OutputStream os = socket.getOutputStream();
            //3.把字节输出流包装成一个打印流
            PrintStream ps = new PrintStream(os);
            //ps.print("hello World! 服务端，你好");
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.print("请说：");
                String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}