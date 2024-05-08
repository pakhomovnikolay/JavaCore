import java.util.Random;

public class Lesson_3 {

    private static Random random = new Random();
    public static void main(String[] args) {
        
        /** Генерируем сотрудников, если кол-во нечетное, последним будет создан рукововдитель*/
        Employee[] employees = EmployeeFabric.generateEmployees(5);

        System.out.println("====================================== данные о сгенерированых сотрудниках ======================================");
        /** Выводим данные о сгенерированых сотрудниках */
        Integer i = 0;
        for (Employee employee : employees) {
            System.out.println(Integer.toString(i + 1) + ") " + employee);
            i++;
        }
        System.out.println();

        /** Увеличиваем ЗП, метод увеличит ЗП всем кроме руководителей */
        for (Employee employee : employees) {
            try {
                Employee.salaryIncreases(employee, random.nextInt((int)employee.salary, (int)employee.salary * 2));
            } catch (Exception e) {
                System.out.println(employee.name + " - " + e);
            }
            
        }

        /** Выводим данные о сгенерированых после изменения ЗП */
        System.out.println("============================= данные о сгенерированых сотрудниках после изменения ЗП =============================");
        i = 0;
        for (Employee employee : employees) {
            System.out.println(Integer.toString(i + 1) + ") " + employee);
            i++;
        }
        System.out.println();

        System.out.println("================================= Результат сравления даты рождения сотрудников ==================================");
        /** Сравниваем даты рождения сотрудников */
        for (int j = 0; j < employees.length - 1; j++) {
            int result = employees[j].compare(employees[j], employees[j + 1]);
            if (result < 0) {
                System.out.println(employees[j].surName + " " + employees[j].name + " младше " + employees[j + 1].surName + " " + employees[j + 1].name);
            }
            else if (result > 0) {
                System.out.println(employees[j].surName + " " + employees[j].name + " страше " + employees[j + 1].surName + " " + employees[j + 1].name);
            }
            else {
                System.out.println(employees[j].surName + " " + employees[j].name + " и " + employees[j + 1].surName + " " + employees[j + 1].name + " ровесники.");
            }            
        }
    }
}
