package GUI;

import data.CellArray;
import models.ForcedListSelectionModel;
import options.ReadFile;
import options.WriteFileComponents.ImageFilter;
import options.WriteFile;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExcelForm implements CellArray {
    private JButton writeFileButton;
    private JPanel panelMain;
    private JButton OpenFile;
    private JFileChooser fc;
    private File file;

    static String[] columnNames = {"Nume", "Prenume", "Grupa", "Buget"};

    Object[][] data = {
            {"Creanga", "Ion", "IS21Z", "Da"},
            {"Turcanu", "Tudor", "IS21Z", "Da"},
            {"Lungu", "Andrei", "IS21Z", "Nu"},
            {"Bazaochi", "Dumitru", "IS21Z", "Da"},
            {"Popov", "Marinela", "IS21Z", "Da"},
            {"Popov", "Dumitru", "IS21Z", "Da"},
            {"Eminescu", "MIhai", "IS21Z", "Nu"}
    };

    public ExcelForm() {
        OpenFile.addActionListener(new ActionListener() {
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
        InsertRows();
    }

    public void InsertRows() {
        JFrame frame = new JFrame("Inserting rows in the table!");
        JPanel panel = new JPanel();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.setLayout(new BorderLayout());
        panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        panel.add(table, BorderLayout.CENTER);
        //Insert first position
       // model.insertRow(0, new Object[]{"Ranjan", "50"});
        //Insert 4 position
       // model.insertRow(3, new Object[]{"Amar", "600"});
        //Insert last position
       // model.insertRow(table.getRowCount(),new Object[]{"Sushil","600"});
        //setReorderingAllowed(boolean reorderingAllowed)
        table.setSelectionModel(new ForcedListSelectionModel());
        table.getTableHeader().setReorderingAllowed(false);
        panel.add(table);
        frame.add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
            ExcelForm form = new ExcelForm();
            form.initComponents();
        }

    private void createUIComponents() {

    }
}
