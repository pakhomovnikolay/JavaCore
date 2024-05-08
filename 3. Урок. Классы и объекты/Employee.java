import java.util.Comparator;

public abstract class Employee implements Comparator<Employee> {

    /**
     * Метод сравнения года рождения двух сотрудников
     * @param e1
     * @param e2
     * @return Возвращает 0, если даты рождения равны.
     * Возвращает значение меньше 0, если дата рождения первого сотрудника меньше.
     * Возвращает значение больше 0, если дата рождения первого сотрудника больше.
     */
    @Override
    public int compare(Employee e1, Employee e2){

        int result = 0;
        if (compareYear(e1.year, e2.year) != 0) {
            result = compareYear(e1.year, e2.year);
        }
        else if (compareMonth(e1.month, e2.month) != 0) {
            result = compareMonth(e1.month, e2.month);
        }
        else if (compareDay(e1.day, e2.day) != 0) {
            result = compareDay(e1.day, e2.day);
        }
        return  result;
    }
    
    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    /**
     * Дата рождения - Год
     */
    protected Integer year;

    /**
     * Дата рождения - Месяц
     */
    protected Integer month;

    /**
     * Дата рождения - День
     */
    protected Integer day;

    /**
     * Метод повышения заработной платы
     * @return заработная плата в месяц
     */
    public static void salaryIncreases(Employee e, double newSalary) throws RuntimeException {
        if (!validationNewSalary(e.salary, newSalary)) {
            throw new RuntimeException("Уровень заработной платы должен быть больше текущей");
        }

        if (e instanceof Worker) {
            e.salary = newSalary;
        }
    }

    private static boolean validationNewSalary(double currSalary, double newSalary) {
        return newSalary > 0 && newSalary > currSalary;
    }

    /**
     * Конструктор класса
     * @param surName Фамилия
     * @param name Имя
     * @param salary Ставка заработной платы
     * @param Year Дата рождения - Год
     * @param Month Дата рождения - Месяц
     * @param Day Дата рождения - День
     */
    public Employee(String surName, String name, double salary, Integer year, Integer month, Integer day) {
        this.surName = surName;
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Метод сравнения года
     * @param year1
     * @param year2
     * @return
     */
    private int compareYear(Integer year1, Integer year2) {
        return  Integer.compare(year1, year2);
    }

    /**
     * Метод сравнения месяца
     * @param month1
     * @param month2
     * @return
     */
    private int compareMonth(Integer month1, Integer month2) {
        return  Integer.compare(month1, month2);
    }

    /**
     * Метод сравнения дня
     * @param day1
     * @param day2
     * @return
     */
    private int compareDay(Integer day1, Integer day2) {
        return  Integer.compare(day1, day2);
    }

    @Override
    public String toString() {
        String Category = this instanceof Worker ? "Работник" : "Руководитель";
        String result = "[" +
                        "Категория - " + Category + "; " +
                        "Имя - " + this.name + "; " +
                        "Фамилия - " + this.surName + "; " +
                        "Дата рождения (Год) - " + this.year + "; " +
                        "Дата рождения (Месяц) - " + this.month + "; " +
                        "Дата рождения (День) - " + this.day + "; " +
                        "Текущая ставка - " + this.salary + "; " +
                        "]";
        
        return result;
    }
}