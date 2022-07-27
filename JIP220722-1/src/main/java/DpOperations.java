import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DpOperations {
    public static void insertEmployee(Employee employee) {
        final String insertQuery = "insert into \"employee\" " +
                "(\"name\",\"surname\",\"title\",\"birthyear\") " +
                "values(?,?,?,?);";

        try (Connection connection = DBConnector.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            connection.setAutoCommit(false);//
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurName());
            preparedStatement.setString(3, employee.getTitle());
            preparedStatement.setInt(4, employee.getBirthYear());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Employee>getAllEmployee(OrderFiled orderFiled){
        List<Employee>employees=new ArrayList<>();
        final String readQuery = "select * from \"employee\" order by "+orderFiled.getOrderField();
        try(Connection connection =DBConnector.getConnection(); Statement statement=connection.createStatement()){

            ResultSet resultSet=statement.executeQuery(readQuery);
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("Surname");
                String title=resultSet.getString("title");
                int birthYear=resultSet.getInt("birthyear");
                employees.add(new Employee(id,name,surname,title,birthYear));
            }
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return employees;
    }
}
