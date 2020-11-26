package options;

import models.CellArrayModelInterface;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcelFile implements CellArrayModelInterface {

    int mode;

    public WriteExcelFile(int mode) {
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

        int rowCount = 0;
        if (mode == 1) {

            for (models.TXTFileModel txtFileModel : textFileList) {
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;

                for (int j = 0; j < 5; j++) {
                    Cell cell = row.createCell(columnCount++);
                    if (j == 4) {
                        cell.setCellValue(Double.parseDouble(txtFileModel.getValue(j)));
                    } else {
                        cell.setCellValue(txtFileModel.getValue(j));
                    }
                }
            }

        } else {
            int columnCount = 0;

            int modelVal = 0;
            for (int i = 0; i < stringValueList.size() / 5; i++) {
                Row row = sheet.createRow(++rowCount);
                for (int j = 0; j < 5; j++) {
                    Cell cell = row.createCell(columnCount++);
                    if (j == 4) {
                        cell.setCellValue(Double.parseDouble(stringValueList.get(modelVal).getStringData()));
                    } else {
                        cell.setCellValue(stringValueList.get(modelVal).getStringData());
                    }
                    modelVal += 1;
                }
                columnCount = 0;
            }
        }

        sheet = workbook.getSheetAt(0);
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        XSSFCell formulaCell = sheet.getRow(0).createCell(lastCellNum);
        formulaCell.setCellFormula("AVERAGE(E:E)");

        XSSFFormulaEvaluator formulaEvaluator =
                workbook.getCreationHelper().createFormulaEvaluator();
        formulaEvaluator.evaluateFormulaCell(formulaCell);


        try (FileOutputStream outputStream = new FileOutputStream("testare.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
