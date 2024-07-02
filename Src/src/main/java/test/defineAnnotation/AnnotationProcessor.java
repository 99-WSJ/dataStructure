package test.defineAnnotation;

/**
 * @author wsj
 * @description
 * @date 2024年07月02日 22:42
 */
import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void processAnnotations(Object obj) {
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(AutoFill.class)) {
                AutoFill autoFill = method.getAnnotation(AutoFill.class);
                if (autoFill.value() == OperationType.INSERT) {
                    System.out.println("Processing insert operation for method: " + method.getName());
                    // 进行插入操作的预处理或后处理
                } else if (autoFill.value() == OperationType.UPDATE) {
                    System.out.println("Processing update operation for method: " + method.getName());
                    // 进行更新操作的预处理或后处理
                }
            }
        }
    }
}
