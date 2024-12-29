package telran.employees;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter(Params.FILE_NAME)) {
            EmployeeGenerator employeeGenerator = new EmployeeGenerator();
            int idCounter = Params.MIN_ID;

            for (var departmentEntry : Params.DEPARTMENT_ROLES.entrySet()) {
                String department = departmentEntry.getKey();
                for (var roleEntry : departmentEntry.getValue().entrySet()) {
                    String role = roleEntry.getKey();
                    int count = roleEntry.getValue();
                    idCounter = employeeGenerator.generateEmployees(writer, idCounter, role, department, count);
                }
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}