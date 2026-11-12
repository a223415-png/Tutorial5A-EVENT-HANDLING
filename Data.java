import java.util.ArrayList;

public class Data {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Book> books = new ArrayList<Book>();

    // sample data so the Borrow window is not empty (delete if not wanted)
    static {
        students.add(new Student("Ali Imran", "A123456"));
        students.add(new Student("Abu Bakar", "A112365"));
        books.add(new Book("Harry Potter", "J K Rowling"));
        books.add(new Book("Lord of The Ring", "J R R Tolkien"));
        books.add(new Book("The Secret of Lost Stone", "Melissa Payne"));
    }
}
