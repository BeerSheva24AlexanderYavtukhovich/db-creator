package telran.employees;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class EmployeeGenerator {

    private static final Random RANDOM = new Random();

    public int generateEmployees(FileWriter writer, int startId, String role, String department, int count)
            throws IOException {
        for (int i = 0; i < count; i++) {
            int id = startId++;
            int basicSalary = getRandomNumber(Params.MIN_BASIC_SALARY, Params.MAX_BASIC_SALARY);
            double factor = role.equals("Manager") ? getRandomDouble(Params.MIN_FACTOR, Params.MAX_FACTOR) : 0.0;
            int wage = role.contains("Wage") || role.equals("SalesPerson")
                    ? getRandomNumber(Params.MIN_WAGE, Params.MAX_WAGE)
                    : 0;
            int hours = role.contains("Wage") || role.equals("SalesPerson")
                    ? getRandomNumber(Params.MIN_HOURS, Params.MAX_HOURS)
                    : 0;
            double percent = role.equals("SalesPerson") ? getRandomDouble(Params.MIN_PERCENT, Params.MAX_PERCENT) : 0.0;
            double sales = role.equals("SalesPerson") ? getRandomDouble(Params.MIN_SALES, Params.MAX_SALES) : 0.0;

            writer.write(String.format("%d,%s,%d,%s,%s,%s,%s,%s,%s\n",
                    id, role, basicSalary, department,
                    formatValue(factor), formatValue(wage), formatValue(hours),
                    formatValue(percent), formatValue(sales)));
        }
        return startId;
    }

    private int getRandomNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    private double getRandomDouble(double min, double max) {
        return min + (max - min) * RANDOM.nextDouble();
    }

    private String formatValue(double value) {
        return value > 0 ? String.format("%.2f", value) : "";
    }

    private String formatValue(int value) {
        return value > 0 ? String.valueOf(value) : "";
    }
}
