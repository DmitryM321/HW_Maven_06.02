import dao.CityDAO;
import dao.CityDAOImpl;
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
        CityDAO cityDAO = new CityDAOImpl();

// метод 5 deleteById
//          City city4 = cityDAO.readById(7);
//          cityDAO.deleteById(cityDAO.readById(7));

////      метод 4 update
//        City city4 = new City(7, "Улан-Батор" );
//         cityDAO.update(city4);

//        метод 3 readAll
//        List<City> cities = cityDAO.readAll();
//        for (City city : cities) {
//            System.out.println(city);

//      метод 2 readById
//         Employee employee1 = new Employee("Фёдор", "Швейар", "m", 55);
//        City city2 = cityDAO.readById(2);
//        employee1.setCity_name(city2);
//        employeeDAO.create(employee1);

//      метод 1 create(city1)
//        City city1 = new City("Kizhi");
//        cityDAO.create(city1);

        }
    }




