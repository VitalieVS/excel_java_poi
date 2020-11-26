package options;

import models.CellArrayModelInterface;
import models.ForcedListSelectionModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CreateTableData implements CellArrayModelInterface {
    int mode;

    public CreateTableData(int mode) {
        this.mode = mode;
    }

    public void insertRows() {
        JFrame frame = new JFrame("Created Table !");
        JPanel panel = new JPanel();
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.setLayout(new BorderLayout());
        panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        panel.add(table, BorderLayout.CENTER);

        if (mode == 1) {
            for (int i = 0; i < textFileList.size(); i++) {
                model.insertRow(i, new Object[]{
                        textFileList.get(i).getNume(),
                        textFileList.get(i).getPrenume(),
                        textFileList.get(i).getGrupa(),
                        textFileList.get(i).getBursa(),
                        textFileList.get(i).getMedia()
                });
            }

        } else {
            int modelVal = 0;
            for (int i = 0; i < stringValueList.size() / 5; i++) {
                model.insertRow(i, new Object[]{
                        stringValueList.get(modelVal).getStringData(),
                        stringValueList.get(modelVal + 1).getStringData(),
                        stringValueList.get(modelVal + 2).getStringData(),
                        stringValueList.get(modelVal + 3).getStringData(),
                        stringValueList.get(modelVal + 4).getStringData()
                });
                modelVal += 5;
            }
        }

        table.setSelectionModel(new ForcedListSelectionModel());
        table.getTableHeader().setReorderingAllowed(false);
        panel.add(table);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
