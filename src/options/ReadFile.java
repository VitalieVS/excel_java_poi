package options;

import data.CellNumericValueData;
import data.CellStringValueData;
import options.WriteFileComponents.Utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFile {
    File inputFile;

    public ReadFile(File inputFile) {
        this.inputFile = inputFile;
    }

    List<CellStringValueData> stringValueList = new ArrayList<>();
    List<CellNumericValueData> numericValueList = new ArrayList<>();

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

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellType() == CellType.STRING) {
                        CellStringValueData foo = new CellStringValueData(
                                currentCell.getStringCellValue(),
                                currentCell.getRowIndex(),
                                currentCell.getColumnIndex());
                        stringValueList.add(foo);
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        CellNumericValueData foo = new CellNumericValueData(
                                currentCell.getNumericCellValue(),
                                currentCell.getRowIndex(),
                                currentCell.getColumnIndex());
                        numericValueList.add(foo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("row String data:");
        for (int i = 0; i < stringValueList.size(); i++) {
            System.out.println(stringValueList.get(i).getRowData());
        }

        System.out.println("row Numeric data:");

        for (int i = 0; i < numericValueList.size(); i++) {
            System.out.println(numericValueList.get(i).getNumericData());
        }

       // for (int i = 0; i < clientList.size(); i++) {
          //  System.out.println(clientList);
       // }

    }
}
