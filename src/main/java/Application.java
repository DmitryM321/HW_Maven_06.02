import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "8363";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
// метод 5
//            employeeDAO.deleteById(8);

//метод 4
            employeeDAO.updateById(7, 28);
// метод 3
            List<Employee> employees = employeeDAO.readAll();
            for (Employee emp : employees) {
                System.out.println(emp);
// метод 2
                System.out.println(employeeDAO.readById(2));
// метод 1
                City city1 = new City(2, "Rio");
                Employee employee1 = new Employee("ЗавКультОтд", "Вяземская", "f", 25, city1);
                employeeDAO.create(employee1);
// Задание 1 - 4
//        try (final Connection connection = DriverManager.getConnection(url, user, password);
//
//             PreparedStatement statement = connection.prepareStatement(
//                     "SELECT * FROM employee WHERE id = (?)")) {
//            statement.setInt(1, 3);
//            final ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String first_name = "First_name "  + resultSet.getString("first_name");
//                String last_name = "Last_name "  + resultSet.getString("last_name");
//                String gender = "Gender "  + resultSet.getString("gender");
//                String city = "City "  + resultSet.getInt("city_id");
//                System.out.println(first_name);
//                System.out.println(last_name);
//                System.out.println(gender);
//                System.out.println(city);


            }
        }
    }
}

