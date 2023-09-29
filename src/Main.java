import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        boolean flag=true;
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        Scanner sc=new Scanner(System.in);
        while(flag){
            System.out.println("***************************");
            System.out.println("Enter 1: To Insert Employee");
            System.out.println("Enter 2: To Update Employee");
            System.out.println("Enter 3: To Delete Employee");
            System.out.println("Enter 4: To Get All Employee");
            System.out.println("Enter 5: To Get Employee by ID");
            System.out.println("Enter 6: To Exit");
            System.out.println("***************************");
            int input= sc.nextInt();
            switch (input){
                case 1:{
                    System.out.print("Enter Name: ");
                    String name=sc.next();
                    System.out.println();
                    System.out.print("Enter Email: ");
                    String email=sc.next();
                    Employee employee= new Employee();
                    employee.setName(name);
                    employee.setEmail(email);

                    employeeDao.addEmployee(employee);
                    break;
                }
                case 2:{
                    System.out.print("Enter employee ID : ");
                    int empId=sc.nextInt();
                    System.out.println();
                    System.out.print("Enter Name: ");
                    String name=sc.next();
                    System.out.println();
                    System.out.print("Enter Email: ");
                    String email=sc.next();
                    Employee employee= new Employee();
                    employee.setId(empId);
                    employee.setName(name);
                    employee.setEmail(email);
                    employeeDao.updateEmployee(employee);
                    break;
                }
                case 3:{
                    System.out.print("Enter ID:");
                    int empId=sc.nextInt();
                    employeeDao.deleteEmployee(empId);
                    break;
                }
                case 4:{
                    List<Employee> employeeList=employeeDao.getAllEmployee();
                    for(Employee e:employeeList){
                        System.out.println(e);
                    }
                    break;
                }
                case 5:{
                    System.out.print("Enter employee id:");
                    int empId=sc.nextInt();
                    Employee emp=employeeDao.getEmployee(empId);
                    System.out.println(emp);
                    break;
                }
                case 6:{
                    System.out.println("Exiting....");
                    flag=false;
                    break;
                }
            }
        }
    }
}