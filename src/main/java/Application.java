import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "8363";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);

             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, 3);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String first_name = "First_name "  + resultSet.getString("first_name");
                String last_name = "Last_name "  + resultSet.getString("last_name");
                String gender = "Gender "  + resultSet.getString("gender");
                String city = "City "  + resultSet.getInt("city_id");
                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(gender);
                System.out.println(city);
            }
        }
    }
}