package options;

import models.CellArrayModelInterface;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteFile implements CellArrayModelInterface {
    public void write() throws FileNotFoundException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student Data");

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnNames[i]);
        }

      /*  for (Object[] student : data) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : student) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

       */

        int rowCount = 0;

        for (models.TXTFileModel txtFileModel : textFileList) {
            Row row = sheet.createRow(++rowCount);
            int columnCount = 0;
            Cell cell1 = row.createCell(columnCount++);
            Cell cell2 = row.createCell(columnCount++);
            Cell cell3 = row.createCell(columnCount++);
            Cell cell4 = row.createCell(columnCount++);
            cell1.setCellValue(txtFileModel.getNume());
            cell2.setCellValue(txtFileModel.getPrenume());
            cell3.setCellValue(txtFileModel.getGrupa());
            cell4.setCellValue(txtFileModel.getBursa());
        }

        try (FileOutputStream outputStream = new FileOutputStream("testare.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
