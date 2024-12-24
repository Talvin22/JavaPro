package com.gmail.dzhaparov.homework29_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    private int executeUpdate(String sql, Object... params) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL execution error: " + e.getMessage());
            return 0;
        }
    }

    public void addEmployee(Employee employee) {
        String addEmployeeSQL = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        int rowsAffected = executeUpdate(addEmployeeSQL, employee.getName(), employee.getAge(), employee.getPosition(), employee.getSalary());
        System.out.println(rowsAffected + " rows affected");
    }

    public void updateEmployee(int id, Employee employee) {
        String updateEmployeeSQL = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";
        int rowsAffected = executeUpdate(updateEmployeeSQL, employee.getName(), employee.getAge(), employee.getPosition(), employee.getSalary(), id);
        System.out.println(rowsAffected + " rows affected");
    }

    public void deleteEmployee(int id) {
        String deleteEmployeeSQL = "DELETE FROM employees WHERE id = ?";
        int rowsAffected = executeUpdate(deleteEmployeeSQL, id);
        System.out.println(rowsAffected + " rows affected");
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String selectAllEmployeesSQL = "SELECT * FROM employees";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectAllEmployeesSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");
                employees.add(new Employee(id, name, age, position, salary));
            }
        } catch (SQLException e) {
            System.err.println("SQL fetch error: " + e.getMessage());
        }
        return employees;
    }
}
