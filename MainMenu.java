import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
    private JButton btnStudent, btnBook, btnBorrow;

    public MainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        btnStudent = new JButton("Add Student Info");
        btnBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");

        btnStudent.addActionListener(this);
        btnBook.addActionListener(this);
        btnBorrow.addActionListener(this);

        pane.add(title);
        pane.add(btnStudent);
        pane.add(btnBook);
        pane.add(btnBorrow);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStudent)
            new AddStudentGUI();
        else if (e.getSource() == btnBook)
            new AddBookGUI();
        else if (e.getSource() == btnBorrow)
            new BorrowBookGUI();
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
