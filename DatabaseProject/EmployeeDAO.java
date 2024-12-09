package DatabaseProject;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);

}
