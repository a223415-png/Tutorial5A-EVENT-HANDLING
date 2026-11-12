import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentGUI extends JFrame implements ActionListener {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea areaStudents;

    public AddStudentGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));

        txtName = new JTextField(20);
        txtMatric = new JTextField(20);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        areaStudents = new JTextArea(5, 30);
        areaStudents.setEditable(false);

        // top: fields and buttons
        JPanel fields = new JPanel(new GridLayout(2, 2, 5, 5));
        fields.add(new JLabel("Name:"));
        fields.add(txtName);
        fields.add(new JLabel("Matric:"));
        fields.add(txtMatric);

        JPanel buttons = new JPanel();
        buttons.add(btnAdd);
        buttons.add(btnList);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(fields);
        top.add(buttons);

        // bottom: list area
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JLabel("Students:"), BorderLayout.NORTH);
        bottom.add(new JScrollPane(areaStudents), BorderLayout.CENTER);

        pane.add(top, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);

        setTitle("Add Student Info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 280);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (name.equals("") || matric.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill in name and matric!");
                return;
            }
            Data.students.add(new Student(name, matric));   // create Student object
            txtName.setText("");
            txtMatric.setText("");
        } else if (e.getSource() == btnList) {
            String text = "";
            for (Student s : Data.students)
                text += s.getInfo() + "\n";
            areaStudents.setText(text);
        }
    }
}
