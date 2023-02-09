package dao;

import model.City;
import model.Employee;
import java.sql.SQLException;
import java.util.List;

public interface CityDAO {
    void create(City city);
    City readById(int id) throws SQLException;
    List<City> readAll();
    void deleteById(City city);
    void update(City city) throws SQLException;


}
