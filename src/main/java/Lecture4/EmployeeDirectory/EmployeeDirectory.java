package Lecture4.EmployeeDirectory;


import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> searchByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<String> searchPhoneNumbersByName(String name) {
        List<String> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                result.add(employee.getPhoneNumber());
            }
        }
        return result;
    }

    public Employee searchByEmployeeNumber(int employeeNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber() == employeeNumber) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        directory.addEmployee(new Employee(1, "John", "1234567890", 5));
        directory.addEmployee(new Employee(2, "Jane", "0987654321", 3));
        directory.addEmployee(new Employee(3, "Tom", "9876543210", 7));

        System.out.println("Employees with 5 years of experience:");
        List<Employee> employeesWithExperience = directory.searchByExperience(5);
        for (Employee employee : employeesWithExperience) {
            System.out.println(employee);
        }

        System.out.println("Phone numbers of employees named Jane:");
        List<String> phoneNumbers = directory.searchPhoneNumbersByName("Jane");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }

        System.out.println("Employee with employee number 3:");
        Employee employeeWithNumberThree = directory.searchByEmployeeNumber(3);
        System.out.println(employeeWithNumberThree);
    }
}

class Employee {
    private int employeeNumber;
    private String name;
    private String phoneNumber;
    private int experience;

    public Employee(int employeeNumber, String name, String phoneNumber, int experience) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                '}';
    }
}