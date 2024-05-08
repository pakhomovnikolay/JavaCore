import java.util.Random;

public class EmployeeFabric {
    private static Random random = new Random();

    public static Worker generateWorker(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        int salary = random.nextInt(60000, 120001);
        Integer day = random.nextInt(1, 31);
        Integer month = random.nextInt(1, 12);
        Integer year = random.nextInt(1950, 2004);

        return new Worker(surnames[random.nextInt(surnames.length)],
                            names[random.nextInt(names.length)], salary, year, month, day);
    }

    public static Manager generateManager(){
        String[] names = new String[] { "Иван", "Максим", "Андрей", "Клим", "Марк", "Тихон", "Альберт", "Тимофей", "Кирилл", "Максим" };
        String[] surnames = new String[] { "Лебедев", "Кириллов", "Князев", "Никифоров", "Попов", "Мальцев", "Никифоров", "Никольский", "Романов", "Колесников" };
        int salary = random.nextInt(150000, 250000);
        Integer day = random.nextInt(1, 31);
        Integer month = random.nextInt(1, 12);
        Integer year = random.nextInt(1950, 2004);

        return new Manager(surnames[random.nextInt(surnames.length)],
                            names[random.nextInt(names.length)], salary, year, month, day);
    }

    /**
     * Фабрика по созданию рабочих
     * @param count
     * @return
     */
    public static Employee[] generateEmployees(int count){
        Employee[] workers = new Employee[count];
        int length = count - 1;

        if (count % 2 != 0) {
            workers[count - 1] = generateManager();
        }

        for (int i = 0; i < length; i++) {
            workers[i] = generateWorker();
        }
        return workers;
    }
}