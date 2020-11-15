package homework_testing.fourth;

public class Author {
    private String name;
    private String email;
    private char gender;

    Author(String a, String b, char c) {
        this.name = a;
        this.email = b;
        this.gender = c;
    }
    public String getAuthor() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public char getGender() {
        return gender;
    }
}
