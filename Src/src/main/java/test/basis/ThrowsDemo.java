package test.basis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: Src
 * @description: throws 和 throw
 * @author: wsj
 * @create: 2024-10-08 14:21
 **/

public class ThrowsDemo {

    // 方法声明，表明该方法可能抛出 IOException
    public void readFile(String filePath) throws IOException {
        // throw 用于主动抛出异常
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }

        // 尝试打开文件并读取内容
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();

        // 调用方法并处理异常
        try {
            // 尝试读取一个文件
            demo.readFile("example.txt"); // 假设这个文件不存在
        } catch (IOException e) {
            // 捕获并处理 IOException
            System.err.println("An I/O error occurred: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // 捕获并处理 IllegalArgumentException
            System.err.println("Invalid argument: " + e.getMessage());
        }
    }
}
