package DatabaseProject;

import java.util.Scanner;

import static DatabaseProject.Helper.showTitle;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employees by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTitle("1. Add Employee");
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter position: ");
                    String position = scanner.next();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    employeeDAO.addEmployee(new Employee(name, position, salary));
                    break;
                case 2:
                    showTitle("2. View All Employees");
                    for (Employee employee : employeeDAO.getAllEmployees()) {
                        System.out.println(employee.toString());
                    }
                    break;
                case 3:
                    showTitle("3. View Employees by ID");
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee employee = employeeDAO.getEmployeeById(searchId);
                    if (employee != null) {
                        System.out.println(employee.toString());
                    } else {
                        System.out.println("Employee not found with ID: " + searchId);
                    }
                    break;
                case 4:
                    showTitle("4.Update Employee");
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new position: ");
                    String newPosition = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    employeeDAO.updateEmployee(new Employee(updateId, newName, newPosition, newSalary));
                    break;
                case 5:
                    showTitle("5. Delete Employee");
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    employeeDAO.deleteEmployee(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
