import java.util.*;

public class Employee {
    double salary;
    Map<String, List> salariesByGroup = new HashMap<>();
    List <String> partTimers = new ArrayList<>(),  fullTimers = new ArrayList<>(), contractors = new ArrayList<>();

    // Employee constructor
    public Employee(List<List<String>> employees) {
    }

    public String getName(List employee ) {
        return employee.get(0).toString();
    }
    public double getRate(List employee) {
        return Double.parseDouble(employee.get(1).toString()); // First casts as double since the parsed CSV list elements are stored as strings
    }
    public double getHours(List employee) {
        return Double.parseDouble(employee.get(2).toString());
    }
    public String getRole(List employee) {
        return employee.get(3).toString();
    }
    /*
    Input: List of employees and their attributes parsed from a CSV file
        CSV schema: Name|Rate|Hours|Role
    Output: Displays all employee information in the console
     */
    public void displayAllEmployeesAndSalaries (List<List<String>> employees) {
        System.out.println("------------------------------");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println( "Employee Name: " + getName(employees.get(i)) + "\n" + "Rate: " + getRate(employees.get(i)) + "\n"
                    + "Weekly Hours: " + getHours(employees.get(i)) + "\n" + "Role: " + getRole(employees.get(i)) + "\n" +
                    "Salary: $" + getSalary(employees.get(i)));
            System.out.println("------------------------------");
        }
    }
    /*
    Input: Employee record from CSV parsed list of employees
    Returns: Appropriate salary based on criteria for each role
    Also populates salariesByGroup map to group salaries by roles (Displays using displaySalariesByRoles())
     */
    public double getSalary (List employee) {
        if (getRole(employee).equals("PART TIME")) {
            salary = getRate(employee) * getHours(employee) * 52;
            partTimers.add(getName(employee));
            partTimers.add("$" + String.valueOf(salary));
            // What gets displayed when grouping by role
            salariesByGroup.put("Part Time: ", partTimers);
        }
        else if (getRole(employee).equals("FULL TIME")) {
            if ((getRate(employee) * getHours(employee) * 52) > 50000) {
                salary = 50000;
            }
            else {
                salary = getRate(employee) * getHours(employee) * 52;
            }
            fullTimers.add(getName(employee));
            fullTimers.add("$" + String.valueOf(salary));
            salariesByGroup.put("Full Time: ", fullTimers);
        }
        else if (getRole(employee).equals("CONTRACT")) {
            salary =  getRate(employee) * getHours(employee) * 52 + 10000;
            contractors.add(getName(employee));
            contractors.add("$" + String.valueOf(salary));
            salariesByGroup.put("Contract: ", contractors);
        }
        else {
            salary = 0;
        }
        return salary;
    }
    /*
    Input: List of employees
    Output: Prints grouped employee salaries based on their roles
     */
    public void displaySalariesByRoles (List<List<String>> employees) {
        for (int i = 0; i < employees.size(); i++) {
            getSalary(employees.get(i));
        }
        for (Map.Entry<String, List> entry : salariesByGroup.entrySet()) {
            System.out.println(entry.getKey()+" : " +  entry.getValue());
        }
    }
}
