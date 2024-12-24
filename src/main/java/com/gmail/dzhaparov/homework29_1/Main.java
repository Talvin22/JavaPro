package com.gmail.dzhaparov.homework29_1;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.connectDatabase();
        databaseConnector.initializeDatabase();

        EmployeeDAO employeeDAO = new EmployeeDAO(databaseConnector.getConnection());


        Employee employee1 = new Employee(1, "Tom", 29, "Software Developer", 12.400);
        Employee employee2 = new Employee(2, "Niko", 22, "CAD Engineer", 5.200);
        employeeDAO.addEmployee(employee1);
        employeeDAO.updateEmployee(1, employee2);
        employeeDAO.deleteEmployee(3);
        employeeDAO.getAllEmployees().forEach(System.out::println);

        databaseConnector.disconnectDatabase();

    }

}
