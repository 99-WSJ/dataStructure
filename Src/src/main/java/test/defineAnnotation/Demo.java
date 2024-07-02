package test.defineAnnotation;

/**
 * @author wsj
 * @description
 *
 *
 * @date 2024年07月02日 22:42
 */
public class Demo {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Employee emp = new Employee("John Doe");

        // 调用方法来演示注解处理
        service.insert(emp);
        service.update(emp);
        service.delete(emp);

        // 处理注解
        AnnotationProcessor.processAnnotations(service);
    }
}
