package GUI;

import options.WriteFile;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcelForm {
    private JButton writeFileButton;
    private JPanel panelMain;
    private JButton OpenFile;
    private JTable table1;
    private JFileChooser fc;

    public ExcelForm() {

    }

    public void initComponents() {
        JFrame frame = new JFrame("Excel Editor");
        frame.setContentPane(new ExcelForm().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        writeFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriteFile writer = new WriteFile();
                writer.write();
            }
        });
        OpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc = new JFileChooser();
                fc.showOpenDialog(panelMain);
            }
        });
    }

    public static void main(String[] args) {
            ExcelForm form = new ExcelForm();
            form.initComponents();
        }
    }
