package test.basis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo {
    // Checked Exception: FileNotFoundException
    public static void checkedExceptionExample() throws FileNotFoundException {
        File file = new File("nonexistent_file.txt");
        FileInputStream fis = new FileInputStream(file); // 可能抛出FileNotFoundException
    }

    // Runtime Exception: ArithmeticException
    public static void runtimeExceptionExample() {
        int result = 10 / 0; // 会抛出ArithmeticException
    }

    // Error: StackOverflowError
    public static void errorExample() {
        recursiveMethod(); // 会导致栈溢出，抛出StackOverflowError
    }

    public static void recursiveMethod() {
        recursiveMethod();
    }

    public static void main(String[] args) {
        try {
            // 调用抛出Checked Exception的方法
            checkedExceptionExample();
        } catch (FileNotFoundException e) {
            System.out.println("Caught Checked Exception: " + e);
        }

        try {
            // 调用抛出Runtime Exception的方法
            runtimeExceptionExample();
        } catch (ArithmeticException e) {
            System.out.println("Caught Runtime Exception: " + e);
        }

        // 调用抛出Error的方法
        errorExample();
    }
}
