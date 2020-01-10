package sample;

public class Teacher {
    private final int ID;
    private String name;
    private String surname;
    private String email;

    public Teacher(int ID, String name, String surname, String email) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String toString(){
        return name + ", " + surname;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
