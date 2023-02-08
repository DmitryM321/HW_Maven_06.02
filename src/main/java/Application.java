import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

////      метод 5
//        Employee employee2 = new Employee(27, "Poligraf","Sharikov", "m" ,27,3);
//         employeeDAO.deleteById(employee2);
//
////      метод 4 update
//        Employee employee3 = new Employee(3, "Darya", "Ivanova", "f", 24, 5);
//         employeeDAO.update(employee3);
//
////     метод 3 readALL
//        List<Employee> employees = employeeDAO.readAll();
//         for (Employee empl : employees) {
//            System.out.println(empl);
////     метод 2 readById(int id)
//         System.out.println(employeeDAO.readById(1));
//
////     метод 1 create(Employee employee)
//        Employee employee1 = new Employee("Poligraf", "Sharikov", "m", 27, 3);
//        employeeDAO.create(employee1);
    }
}








