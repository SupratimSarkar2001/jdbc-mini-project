import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    void deleteEmployee(int id) throws SQLException;

    void addEmployee(Employee e) throws SQLException;

    void updateEmployee(Employee e) throws SQLException;

    List<Employee> getAllEmployee();

    Employee getEmployee(int id);

}
