public class Shopper extends Employee {

    /**
     * Пол
     */
    protected MaleEnum male;

    /**
     * Метод возвращает пол покупателя
     * @return
     */
    public MaleEnum getMale() {
        return male;
    }

    /**
     * Метод устанавливает пол покупателя
     * @param male
     */
    public void setMale(MaleEnum male) {
        this.male = male;
    }

    /**
     * Коструктор класса
     * @param surName Фамилия
     * @param name Имя
     * @param salary Ставка заработной платы
     * @param Year Дата рождения - Год
     * @param Month Дата рождения - Месяц
     * @param Day Дата рождения - День
     * @param male Пол
     */
    public Shopper(String surName, String name, double salary, Integer year, Integer month, Integer day, MaleEnum male) {
        super(surName, name, salary, year, month, day);
        this.male = male;
    }
    
    /**
     * Метод поздравления покупателя с праздником
     * @param holidays
     * @throws RuntimeException
     */
    public void congratulations(HolidaysEnum holidays) throws RuntimeException {
         switch (holidays) {

            case NewYear:
                System.out.println("Покупателю " + this.surName + " " + this.name +
                                    " поздравительная открытка " + holidays.getTitle() + " успешно отправлена.");
                break;
            
            case March8:
                if (male == MaleEnum.male) {
                    throw new RuntimeException("Ошибка отправления поздравительной открытки " + holidays.getTitle() + " для покупателя - " +
                                            this.surName + " " + this.name + ". Указан некорректный праздник");
                }
                else {
                    System.out.println("Покупателю " + this.surName + " " + this.name +
                                        " поздравительная открытка " + holidays.getTitle() + " успешно отправлена.");
                }
                break;

            case February23:
                if (male == MaleEnum.female) {
                    throw new RuntimeException("Ошибка отправления поздравительной открытки " + holidays.getTitle() + " для покупателя - " +
                                            this.surName + " " + this.name + ". Указан некорректный праздник");
                }
                else {
                    System.out.println("Покупателю " + this.surName + " " + this.name +
                                        " поздравительная открытка " + holidays.getTitle() + " успешно отправлена.");
                }
                break;
                
            default:
                throw new RuntimeException("Ошибка отправления поздравительной открытки " + holidays.getTitle() + " для покупателя - " +
                                            this.surName + " " + this.name + ". Указан неизвестный праздник");
        }
    }

    @Override
    public String toString() {
        String result = "[" +
                        "Имя - " + this.name + "; " +
                        "Фамилия - " + this.surName + "; " +
                        "Дата рождения (Год) - " + this.year + "; " +
                        "Дата рождения (Месяц) - " + this.month + "; " +
                        "Дата рождения (День) - " + this.day + "; " +
                        "Текущая ставка - " + this.salary + "; " +
                        "Пол - " + this.male.getTitle() + "; " +
                        "]";
        
        return result;
    }
}
