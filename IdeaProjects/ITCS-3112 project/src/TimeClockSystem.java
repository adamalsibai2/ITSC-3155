import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class TimeClockSystem {
    public static ArrayList<Employee> employees = new ArrayList<>();
    private static final HashMap<String, User> users = new HashMap<>();
    public static User loggedInUser = null;

    // Method to add users to the system
    public static void addUser(User user) {
        users.put(user.username(), user);
    }

    public static Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public static void authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.verifyPassword(password)) { // Use verifyPassword method
            loggedInUser = user;
            System.out.println("You are logged in!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static void clockIn(Employee emp) {
        emp.clockIn();
    }

    public static void clockOut(Employee emp, double hours) {
        emp.clockOut(hours);
    }

    public static void displayTimeCard(Employee emp) {
        emp.displayTimeCard();
    }

    public static void generateReports() {
        if (loggedInUser != null && loggedInUser.isAdmin()) {
            System.out.println("Generating reports....");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Permission denied: Only admins can generate reports.");
        }
    }
}





