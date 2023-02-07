package dao;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);
    Employee readById(int id) throws SQLException;
    List<Employee> readAll();
    void deleteById(int id);
    void updateById(int id, int age) throws SQLException;
}
