package options;

import data.RowData;
import options.WriteFileComponents.Utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFile {
    File inputFile;

    public ReadFile(File inputFile) {
        this.inputFile = inputFile;
    }

    List<RowData> clientList = new ArrayList<>();

    public void read() {
        Workbook workbook;
        try {
            FileInputStream excelFile = new FileInputStream(new File(String.valueOf(inputFile)));
            if (Utils.getExtension(this.inputFile).equals("xls")) {
                workbook = new HSSFWorkbook(excelFile);
            } else {
                workbook = new XSSFWorkbook(excelFile);
            }
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

           // Cell wanted = datatypeSheet.getRow(0).getCell(0);
           // String wantedRef = (new CellReference(wanted)).formatAsString();
           // System.out.println(wantedRef);


            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellType() == CellType.STRING) {
                        RowData foo = new RowData(currentCell.getStringCellValue());
                        clientList.add(foo);
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("row data");
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i).getRowData());
        }

       // for (int i = 0; i < clientList.size(); i++) {
          //  System.out.println(clientList);
       // }

    }
}
