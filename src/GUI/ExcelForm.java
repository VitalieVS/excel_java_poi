package GUI;

import options.ReadFile;
import options.WriteFileComponents.ImageFilter;
import options.WriteFile;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExcelForm {
    private JButton writeFileButton;
    private JPanel panelMain;
    private JButton OpenFile;
    private JTable table1;
    private JFileChooser fc;
    private File file;

    public ExcelForm() {
        OpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (createFileChooser()) {
                   System.out.println("done");
                   ReadFile reader = new ReadFile(file);
                   reader.read();

               } else {
                   System.out.println("nu a ales");
               }

            }
        });
        writeFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WriteFile writer = new WriteFile();
                writer.write();
            }
        });
    }

    public boolean createFileChooser() {
        fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            return true;
        } else {
            return false;
        }
    }


    public void initComponents() {
        JFrame frame = new JFrame("Excel Editor");
        frame.setContentPane(new ExcelForm().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
            ExcelForm form = new ExcelForm();
            form.initComponents();
        }
    }
