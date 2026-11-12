public class Student {
    private String name;
    private String matric;
    private Book borrowedBook;      // each student can borrow only one book

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }

    public String getName()          { return name; }
    public String getMatric()        { return matric; }
    public Book getBorrowedBook()    { return borrowedBook; }
    public void setBorrowedBook(Book b) { borrowedBook = b; }

    // used in combo boxes: Siti Aminah (A147895)
    public String toString() {
        return name + " (" + matric + ")";
    }

    // used in the list: Name : Siti Aminah (A147895)
    public String getInfo() {
        return "Name : " + toString();
    }
}
