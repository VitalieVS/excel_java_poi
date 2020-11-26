package options;

import models.CellArrayModelInterface;
import models.CellStringValueModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteFile implements CellArrayModelInterface {

    int mode ;

    public WriteFile(int mode) {
        this.mode = mode;
    }


    public void write() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student Data");

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnNames[i]);
        }


        if (mode == 1) {
            int rowCount = 0;

            for (models.TXTFileModel txtFileModel : textFileList) {
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;

                for (int j = 0; j < 5; j++ ) {
                    Cell cell = row.createCell(columnCount++);
                    if (j == 4) {
                        cell.setCellValue(Double.parseDouble(txtFileModel.getValue(j)));
                    } else {
                        cell.setCellValue(txtFileModel.getValue(j));
                    }
                }
            }

        } else {
            int rowCount = 0;
            int columnCount = 0;

            int modelVal = 0;
            for (int i = 0; i < stringValueList.size() / 5 ; i++) {
                Row row = sheet.createRow(++rowCount);
                for (int j = 0; j < 5; j++ ){
                    Cell cell = row.createCell(columnCount++);
                    cell.setCellValue(stringValueList.get(modelVal).getStringData());
                    modelVal += 1;
                }
                columnCount = 0;
                };
            }

        try (FileOutputStream outputStream = new FileOutputStream("testare.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
