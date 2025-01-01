import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Adding some employees
        Employee employee1 = new Employee(148, "Alexis Radcliff", 33.97);
        Employee employee2 = new Employee(394, "Sarah Jo", 35.89);
        Employee employee3 = new Employee(282, "Judith Martin", 37.89);
        Employee employee4 = new Employee(564, "Omar Ra", 40.98);
        Employee employee5 = new Employee(987, "Robert Smith", 45.50);
        Employee employee6 = new Employee(765, "Mike Johnson", 50.00);

        // Add employees to the system
        TimeClockSystem.employees.add(employee1);
        TimeClockSystem.employees.add(employee2);
        TimeClockSystem.employees.add(employee3);
        TimeClockSystem.employees.add(employee4);
        TimeClockSystem.employees.add(employee5);
        TimeClockSystem.employees.add(employee6);

        // Adding users to the TimeClockSystem
        User user = new User("admin", "adminPass", true);
        User user1 = new User("user", "userPass", false);

        // Add users to the system's HashMap
        TimeClockSystem.addUser(user);
        TimeClockSystem.addUser(user1);

        Scanner scanner = new Scanner(System.in);

        // Authenticate user
        TimeClockSystem.authenticateUser();

        // Example usage after user authentication
        if (TimeClockSystem.loggedInUser != null) {
            while (true) {
                System.out.print("Enter employee ID to clock in (or type 'exit' to quit): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                try {
                    int id = Integer.parseInt(input);
                   Employee emp = TimeClockSystem.findEmployeeById(id);
                    if (emp != null) {
                        TimeClockSystem.clockIn(emp);
                        System.out.print("Enter hours worked: ");
                        double hours = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        TimeClockSystem.clockOut(emp, hours);
                        TimeClockSystem.displayTimeCard(emp);
                    } else {
                        System.out.println("Employee not found.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid employee ID or 'exit' to quit.");
                }
            }

            // Generate reports
            TimeClockSystem.generateReports();
        }

        scanner.close();
    }

}





