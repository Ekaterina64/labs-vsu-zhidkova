import java.util.HashSet;
import java.util.Set;

public class Employee_build {
    private final Set<Employee> employeeSet = new HashSet<>();

    public Employee Find_Employee(int id, String name, String sex, String birthDay, Division division, int salary) {
        for (Employee employee: employeeSet) {
            if (employee.getID() == id) {
                return employee;
            }
        }

        Employee employee = new Employee(id, name, sex, birthDay, division, salary);
        employeeSet.add(employee);
        return employee;
    }
}
