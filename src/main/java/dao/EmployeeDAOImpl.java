package dao;
import model.City;
import model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))"
        )) {
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity_name().getCity_id());

            statement.execute();
        } catch (SQLException e) {
        }
    }

    @Override
    public Employee readById(int id) {
        Employee employee = new Employee();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.id=city.city_id AND id=(?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity_name(new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return employee;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee INNER JOIN city ON employee.id=city.city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = Integer.parseInt(resultSet.getString("age"));
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name"));

                employees.add(new Employee(id, first_name, last_name, gender, age, city));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateById(int id, int age) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET age=(?) WHERE id=(?)")) {

            statement.setInt(1, id);
            statement.setInt(2, age);
            statement.execute();
        }
    }


        @Override
    public void deleteById(int id){
            try(PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM employee WHERE id=(?)")) {

                statement.setInt(1, id);
                statement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}


