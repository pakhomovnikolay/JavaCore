public enum HolidaysEnum {

    None("Отсутвует праздник"),
    NewYear("С Новым Годом"),
    March8("С международным женским днем"),
    February23("С днем защитника отечества");

    private final String title;

    public String getTitle() {
        return title;
    }

    HolidaysEnum(String title) {
        this.title = title;
    }
}
