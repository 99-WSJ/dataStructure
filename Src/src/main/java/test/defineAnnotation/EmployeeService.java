package test.defineAnnotation;

/**
 * @author wsj
 * @description
 * @date 2024年07月02日 22:41
 */
public class EmployeeService {

    @AutoFill(value = OperationType.INSERT)
    public void insert(Employee employee) {
        // 插入操作的具体实现
        System.out.println("Inserting employee: " + employee.getName());
    }

    @AutoFill(value = OperationType.UPDATE)
    public void update(Employee employee) {
        // 更新操作的具体实现
        System.out.println("Updating employee: " + employee.getName());
    }

    // 不带注解的方法
    public void delete(Employee employee) {
        // 删除操作的具体实现
        System.out.println("Deleting employee: " + employee.getName());
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}