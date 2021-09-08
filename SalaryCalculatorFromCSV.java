
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class SalaryCalculatorFromCSV {
    public static void main(String args[]) {
        // Arguments from the command line: csv file (full path), and calculation type all or group
        String csvFileNameAndPath = args[0];
        String calcTypeArg = args[1];
        File csvFile = new File(csvFileNameAndPath);
        // Parses csv file and stores as list of lists, contents from each line are stored as strings
        List<List<String>> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("[\\|,]"); // Split by | and ,
                employees.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Employee e2 = new Employee(employees);
        while (!calcTypeArg.equalsIgnoreCase("all") && !calcTypeArg.equalsIgnoreCase("group")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Incorrect selection for calculation type argument! \nPlease type 'all' for total salaries, or 'group' for salaries by group:");
            calcTypeArg = input.next();
        }
        if (calcTypeArg.equalsIgnoreCase("all")) {
            e2.displayAllEmployeesAndSalaries(employees);
        } else if (calcTypeArg.equalsIgnoreCase("group")) {
            e2.displaySalariesByRoles(employees);
        }
    }
}
