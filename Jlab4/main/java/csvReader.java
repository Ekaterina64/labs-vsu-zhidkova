import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvReader {
    private static final String path = "src\\main\\resources\\foreign_names.csv";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            Division_build division_build = new Division_build();
            Employee_build employee_build = new Employee_build();

            String line = bufferedReader.readLine();

            List<Employee> emp = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {

                String[] tmp = line.split(";");
                Employee employee = employee_build.Find_Employee(Integer.parseInt(tmp[0]),
                        tmp[1], tmp[2], tmp[3],
                        division_build.Find_Division(tmp[4]), Integer.parseInt(tmp[5]));
                emp.add(employee);
            }
            int i = 1;
            for (Employee employee1 : emp) System.out.println("Employee №" + i++ + ": " + employee1.ToString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}