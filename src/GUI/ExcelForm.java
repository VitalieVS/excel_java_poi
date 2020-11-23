package GUI;

import data.CellArray;
import options.ReadFile;
import options.WriteFileComponents.ImageFilter;
import options.WriteFile;
import options.createTableData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class ExcelForm implements CellArray {
    private JButton writeFileButton;
    private JPanel panelMain;
    private JButton OpenFileButton;
    private JButton createTableButton;
    private JFileChooser fc;
    private File file;

    public ExcelForm() {
        OpenFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createFileChooser()) {
                    ReadFile reader = new ReadFile(file);
                    reader.read();
                }
            }
        });
        writeFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WriteFile writer = new WriteFile();
                try {
                    writer.write();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        createTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTableData tableData = new createTableData();
                tableData.insertRows();
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

    private void createUIComponents() {

    }
}
