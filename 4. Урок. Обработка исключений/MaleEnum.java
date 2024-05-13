public enum MaleEnum {
    
    male("Мужчина"),
    female("Женщина");

    private final String title;

    public String getTitle() {
        return title;
    }

    MaleEnum(String title) {
        this.title = title;
    }
}
