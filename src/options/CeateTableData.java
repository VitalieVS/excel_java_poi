package options;

import models.CellArrayModelInterface;
import models.ForcedListSelectionModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CeateTableData implements CellArrayModelInterface {
    public void insertRows() {
        JFrame frame = new JFrame("Created Table From TXT File!");
        JPanel panel = new JPanel();
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.setLayout(new BorderLayout());
        panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        panel.add(table, BorderLayout.CENTER);
        for (int i = 0; i < textFileList.size(); i++) {
            model.insertRow(i, new Object[] {
                    textFileList.get(i).getNume(),
                    textFileList.get(i).getPrenume(),
                    textFileList.get(i).getGrupa(),
                    textFileList.get(i).getBursa() });
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
