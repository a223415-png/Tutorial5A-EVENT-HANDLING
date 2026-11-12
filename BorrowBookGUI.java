import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBookGUI extends JFrame implements ActionListener {
    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;
    private JLabel lblInfo;

    public BorrowBookGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));

        cmbStudent = new JComboBox<Student>();
        for (Student s : Data.students)
            cmbStudent.addItem(s);

        cmbBook = new JComboBox<Book>();
        for (Book b : Data.books)
            cmbBook.addItem(b);

        btnBorrow = new JButton("Borrow");
        btnBorrow.addActionListener(this);

        // top: combo boxes and button
        JPanel fields = new JPanel(new GridLayout(2, 2, 5, 5));
        fields.add(new JLabel("Student Name & Matric:"));
        fields.add(cmbStudent);
        fields.add(new JLabel("Book Title & Author:"));
        fields.add(cmbBook);

        JPanel buttons = new JPanel();
        buttons.add(btnBorrow);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(fields);
        top.add(buttons);

        // bottom: borrow information
        lblInfo = new JLabel(" ");
        JPanel bottom = new JPanel(new GridLayout(2, 1));
        bottom.add(new JLabel("Borrow Information :"));
        bottom.add(lblInfo);

        pane.add(top, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.SOUTH);

        setTitle("Borrow Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(550, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Student s = (Student) cmbStudent.getSelectedItem();
        Book b = (Book) cmbBook.getSelectedItem();

        if (s == null || b == null) {
            JOptionPane.showMessageDialog(this, "Please add student and book first!");
            return;
        }
        lblInfo.setText(b.borrowBy(s));
    }
}
