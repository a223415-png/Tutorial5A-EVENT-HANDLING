public class Book {
    private String title;
    private String author;
    private Student borrower;       // null = available (only one copy)

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }

    public String borrowBy(Student s) {
        if (borrower != null)
            return "Sorry, this book has already been borrowed.";
        if (s.getBorrowedBook() != null)
            return s.getName() + " has already borrowed a book.";

        borrower = s;
        s.setBorrowedBook(this);
        return s.getName() + " with matric number " + s.getMatric()
             + " has borrow a book with title " + title + ".";
    }

    // used in combo boxes: Harry Potter (J K Rowling)
    public String toString() {
        return title + " (" + author + ")";
    }

    // used in the list: Book title : Harry Potter (Author : J K Rowling)
    public String getInfo() {
        return "Book title : " + title + " (Author : " + author + ")";
    }
}
