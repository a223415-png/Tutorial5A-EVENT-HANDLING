import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookGUI extends JFrame implements ActionListener {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea areaBooks;

    public AddBookGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));

        txtTitle = new JTextField(20);
        txtAuthor = new JTextField(20);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        areaBooks = new JTextArea(5, 30);
        areaBooks.setEditable(false);

        JPanel fields = new JPanel(new GridLayout(2, 2, 5, 5));
        fields.add(new JLabel("Book Title:"));
        fields.add(txtTitle);
        fields.add(new JLabel("Author:"));
        fields.add(txtAuthor);

        JPanel buttons = new JPanel();
        buttons.add(btnAdd);
        buttons.add(btnList);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(fields);
        top.add(buttons);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JLabel("Books:"), BorderLayout.NORTH);
        bottom.add(new JScrollPane(areaBooks), BorderLayout.CENTER);

        pane.add(top, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);

        setTitle("Add Book Info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 280);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (title.equals("") || author.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill in title and author!");
                return;
            }
            Data.books.add(new Book(title, author));        // create Book object
            txtTitle.setText("");
            txtAuthor.setText("");
        } else if (e.getSource() == btnList) {
            String text = "";
            for (Book b : Data.books)
                text += b.getInfo() + "\n";
            areaBooks.setText(text);
        }
    }
}
