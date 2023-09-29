import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    Connection connection;

    public EmployeeDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = "+id;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Employee Deleted");
        } else {
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee (name, email) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("Employee saved");
        }else{
            System.out.println("Oops! something went wrong");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee set name = ?, email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setInt(3, employee.getId());
        int count = preparedStatement.executeUpdate();

        if (count > 0) {
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Oops! Something went wrong while updating the employee");
        }
    }


    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Employee employee = new Employee(id, name, email);
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("There is some error");
        }
        return employees;
    }


    @Override
    public Employee getEmployee(int empId) {
        Employee employee = new Employee();
        String sql = "SELECT * FROM employee where id="+ empId;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            employee = new Employee(id, name, email);
        } catch (SQLException e) {
            System.out.println("There is some error");
        }
        return employee;
    }
}
