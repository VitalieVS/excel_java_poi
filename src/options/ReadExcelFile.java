package options;

import models.CellArrayModelInterface;
import models.CellNumericValueModel;
import models.CellStringValueModel;
import options.WriteFileComponents.Utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile implements CellArrayModelInterface {
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

            for (Row currentRow : datatypeSheet) {
                for (Cell currentCell : currentRow) {
                    if (currentCell.getCellType() == CellType.STRING) {
                        CellStringValueModel foo = new CellStringValueModel(
                                currentCell.getStringCellValue());
                        stringValueList.add(foo);
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        CellNumericValueModel foo = new CellNumericValueModel(
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
