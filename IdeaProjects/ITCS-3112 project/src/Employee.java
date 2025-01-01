
public class Employee {
    private final int id;
    private final String name;
    private final double hourlyPay;
    private double workedHours;
    private boolean isClockedIn;

    public Employee(int id, String name, double hourlyPay) {
        this.id = id;
        this.name = name;
        this.hourlyPay = hourlyPay;
        this.workedHours = 0;
        this.isClockedIn = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void clockIn() {
        if (!isClockedIn) {
            System.out.println(name + " (ID: " + id + ") clocked in.");
            isClockedIn = true;
        } else {
            System.out.println(name + " (ID: " + id + ") is already clocked in.");
        }
    }

    public void clockOut(double hours) {
        if (isClockedIn) {
            if (hours > 0) {
                workedHours += hours;
                System.out.println(name + " (ID: " + id + ") clocked out after " + hours + " hours.");
                isClockedIn = false; // Mark as clocked out
            } else {
                System.out.println("Error: Worked hours must be positive.");
            }
        } else {
            System.out.println(name + " (ID: " + id + ") cannot clock out without clocking in.");
        }
    }

    public double calculatePay() {
        return hourlyPay * workedHours;
    }

    public void displayTimeCard() {
        System.out.printf("Employee ID: %d\n", id);
        System.out.printf("Name: %s\n", name);
        System.out.printf("Hourly Rate: $%.2f\n", hourlyPay);
        System.out.printf("Hours Worked: %.2f\n", workedHours);
        System.out.printf("Total Pay: $%.2f\n", calculatePay());
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Hours Worked: %.2f, Total Pay: $%.2f", id, name, workedHours, calculatePay());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}



