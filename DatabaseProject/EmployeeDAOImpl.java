package DatabaseProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    private final String url = "jdbc:mysql://localhost:3306/EmployeeDB";
    private final String username = "root";
    private final String  password = "yourpassword";

    private static final String addData = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
    private static final String showData = "SELECT * FROM employees";
    private static final String showDataById = "SELECT * FROM employees WHERE id = ?";
    private static final String updateData = "UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?";
    private static final String deleteData = "DELETE FROM employees WHERE id = ?";

    @Override
    public void addEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, username, password); PreparedStatement preparedStatement = connection.prepareStatement(addData)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.executeUpdate();

            System.out.println("Data added successfully to the database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(showData);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                Double salary = rs.getDouble("salary");
                employees.add(new Employee(id, name, position, salary));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null; // Initialize the employee as null

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(showDataById)) {

            // Set the parameter for the query
            preparedStatement.setInt(1, id);

            // Execute the query
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    // Retrieve employee data from ResultSet
                    String name = rs.getString("name");
                    String position = rs.getString("position");
                    double salary = rs.getDouble("salary");

                    // Create the Employee object
                    employee = new Employee(id, name, position, salary);

                } else {
                    System.out.println("No employee found with ID: " + id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee; // Return the retrieved employee or null if not found
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateData)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getId());

            preparedStatement.executeUpdate();

            System.out.println("Data from database updated successfully ");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteData)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Data from the database deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
