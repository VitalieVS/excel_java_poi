package GUI;

import data.CellArray;
import models.ForcedListSelectionModel;
import options.ReadFile;
import options.WriteFileComponents.ImageFilter;
import options.WriteFile;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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


    String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

    Object[][] data = {
            {"Kathy", "Smith",
                    "Snowboarding", "5", "Boolean.FALSE"},
            {"John", "Doe",
                    "Rowing", "3", "Boolean.TRUE"},
            {"Sue", "Black",
                    "Knitting", "2", "Boolean.FALSE"},
            {"Jane", "White",
                    "Speed reading", "20", "Boolean.TRUE"},
            {"Joe", "Brown",
                    "Pool", "10", "Boolean.FALSE"}
    };

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
