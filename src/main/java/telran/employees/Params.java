package telran.employees;

import java.util.Map;

public class Params {
    public static final String FILE_NAME = "employees-sql-data.csv";
    public static final int MIN_ID = 1000;
    public static final int MAX_ID = 9999;
    public static final int MIN_BASIC_SALARY = 5000;
    public static final int MAX_BASIC_SALARY = 50000;
    public static final double MIN_FACTOR = 1.5;
    public static final double MAX_FACTOR = 4.0;
    public static final int MIN_WAGE = 30;
    public static final int MAX_WAGE = 300;
    public static final int MIN_HOURS = 1;
    public static final int MAX_HOURS = 200;
    public static final double MIN_PERCENT = 0.1;
    public static final double MAX_PERCENT = 1.5;
    public static final double MIN_SALES = 1000.0;
    public static final double MAX_SALES = 100000.0;

    public static final Map<String, Map<String, Integer>> DEPARTMENT_ROLES = Map.of(
            "QA", Map.of("Manager", 1, "Employee", 2, "WageEmployee", 10),
            "Development", Map.of("Manager", 1, "WageEmployee", 30),
            "Devops", Map.of("Manager", 1, "Employee", 5),
            "Sales", Map.of("Manager", 1, "SalesPerson", 3));
}