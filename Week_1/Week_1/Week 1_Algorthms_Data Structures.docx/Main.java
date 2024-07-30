class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    // Constructor
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeDatabase {
    private Employee[] employees;
    private int size;

    public EmployeeDatabase(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
        } else {
            System.out.println("Database is full. Cannot add more employees.");
        }
    }

    // Method to search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Method to traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            size--;
        } else {
            System.out.println("Employee not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeDatabase database = new EmployeeDatabase(10);

        Employee employee1 = new Employee(1, "John Doe", "Software Engineer", 50000.0);
        Employee employee2 = new Employee(2, "Jane Doe", "Data Scientist", 60000.0);
        Employee employee3 = new Employee(3, "Bob Smith", "Product Manager", 70000.0);

        database.addEmployee(employee1);
        database.addEmployee(employee2);
        database.addEmployee(employee3);

        System.out.println("All Employees:");
        database.traverseEmployees();

        System.out.println("\nSearch Employee by ID 2:");
        Employee searchedEmployee = database.searchEmployee(2);
        if (searchedEmployee != null) {
            System.out.println(searchedEmployee);
        }

        System.out.println("\nDelete Employee by ID 2:");
        database.deleteEmployee(2);

        System.out.println("\nAll Employees after deletion:");
        database.traverseEmployees();
    }
}