package GUI;

import options.WriteFile;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExcelForm {
    private JButton writeFileButton;
    private JPanel panelMain;

    public ExcelForm() {
        writeFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriteFile writer = new WriteFile();
                writer.write();
            }
        });
    }

    public static void main(String[] args) {
       JFrame frame = new JFrame("App");
       frame.setContentPane(new ExcelForm().panelMain);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
        }
    }
