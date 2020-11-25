package models;

import java.util.ArrayList;
import java.util.List;

public interface CellArrayModelInterface {
   String[] columnNames = {"Nume", "Prenume", "Grupa", "Buget"};

    List<CellStringValueModel> stringValueList = new ArrayList<>();
    List<CellNumericValueModel> numericValueList = new ArrayList<>();
    List<TXTFileModel> textFileList = new ArrayList<>();
}