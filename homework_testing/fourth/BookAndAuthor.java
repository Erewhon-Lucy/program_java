package homework_testing.fourth;

class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String a, Author[] b, double c, int d) {
        name = a;
        authors = b;
        price = c;
        qty = d;
    }
    public Book(String a, Author[] b, double c) {
        this(a,b,c,0);
    }
    public String getName() {
        return name;
    }
    public Author[] getAuthors() {
        return authors;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double x) {
        price = x;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int y) {
        qty = y;
    }
    public String authorToString(Author[] a) {
        return "Author[name=" + a[0].getAuthor() + ",email=" + a[0].getEmail() + ",gender=" + a[0].getGender() + "], "
            + "Author[name=" + a[1].getAuthor() + ",email=" + a[1].getEmail() + ",gender=" + a[1].getGender() + "] ";
    }
    public String toString() {
        return "Book[name=" + name + ",authors={" + authorToString(authors) + "},price=" + price + ",qty=" + qty + "]";
    }
    public String getAuthorNames() {
        return authors[0].getAuthor() + "," + authors[1].getAuthor();
    }
}

public class BookAndAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Timmy", "12345", 'f');
        Author a2 = new Author("Jack", "54321", 'm');
        Author[] Au = {a1,a2};
        Book Bo = new Book("Happy UESTC", Au, 3.0, 4);
        System.out.println("Name: " + Bo.getName());
        System.out.println("Price: " + Bo.getPrice());
        System.out.println("qty: " + Bo.getQty());
        System.out.println("Authors: " + Bo.getAuthorNames());
        System.out.println(Bo.toString());
    }
}
