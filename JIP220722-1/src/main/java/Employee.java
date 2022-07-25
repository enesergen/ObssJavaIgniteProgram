public class Employee {
    private int id;
    private String name;
    private String surName;
    private String title;
    private int birthYear;

    public Employee(int id, String name, String surName, String title, int birthYear) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.title = title;
        this.birthYear = birthYear;
    }
    public Employee( String name, String surName, String title, int birthYear) {
        this.name = name;
        this.surName = surName;
        this.title = title;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getTitle() {
        return title;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
