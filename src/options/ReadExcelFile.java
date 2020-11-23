package options;

import data.CellArray;
import data.CellNumericValueData;
import data.CellStringValueData;
import options.WriteFileComponents.Utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile implements CellArray {
    File inputFile;

    public ReadExcelFile(File inputFile) {
        this.inputFile = inputFile;
    }

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
                                currentCell.getStringCellValue());
                        stringValueList.add(foo);
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        CellNumericValueData foo = new CellNumericValueData(
                                currentCell.getNumericCellValue());
                        numericValueList.add(foo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
