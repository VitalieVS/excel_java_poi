package GUI;

import models.CellArrayModelInterface;
import options.*;
import options.WriteFileComponents.ImageFilter;
import options.WriteFileComponents.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExcelForm implements CellArrayModelInterface {
    private JButton writeFileButton;
    private JPanel panelMain;
    private JButton OpenFileButton;
    private JButton createTableButton;
    private JButton exportToPDFButton;
    private File file;

    public ExcelForm() {
        OpenFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringValueList.clear();
                textFileList.clear();
                if (createFileChooser() && Utils.getExtension(file).equals(Utils.txt)) {
                    ReadTextFile reader = new ReadTextFile(file);
                    reader.readFile();
                } else {
                    ReadExcelFile reader = new ReadExcelFile(file);
                    reader.read();
                }
            }
        });
        writeFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WriteExcelFile writer;
                if (Utils.getExtension(file).equals(Utils.txt)) {
                    writer = new WriteExcelFile(1);
                } else {
                    writer = new WriteExcelFile(2);
                }
                writer.write();
            }
        });
        createTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTableData tableData;
                if (Utils.getExtension(file).equals(Utils.txt)) {
                   tableData = new CreateTableData(1);
                } else {
                    tableData = new CreateTableData(2);
                }
                tableData.insertRows();
            }
        });
        exportToPDFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportToPDF exporter = new ExportToPDF();
                exporter.save();
            }
        });
    }

    public boolean createFileChooser() {
        JFileChooser fc = new JFileChooser();
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
