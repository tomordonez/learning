import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Namor", 500, "The Sea", 95000));
        employees.add(new Employee("Black Panther", 30, "Wakanda", 5000000));

        System.out.println(employees.get(0).raiseSalary());
    }
}
