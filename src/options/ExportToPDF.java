package options;

import com.qoppa.office.ExcelConvertOptions;
import com.qoppa.office.ExcelDocument;
import com.qoppa.office.OfficeException;
import com.qoppa.pdf.PDFException;

import java.io.IOException;

public class ExportToPDF {
    public void save() {
        ExcelDocument excelDoc;
            try {
                excelDoc = new ExcelDocument("testare.xlsx", new ExcelConvertOptions());
                excelDoc.saveAsPDF("test.pdf");
            } catch (IOException | PDFException | OfficeException e) {
                e.printStackTrace();
            }
    }
}
