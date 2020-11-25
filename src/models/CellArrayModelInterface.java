package models;

import java.util.ArrayList;
import java.util.List;

public interface CellArrayModelInterface {
   String[] columnNames = {"Nume", "Prenume", "Grupa", "Buget"};

    Object[][] data = {
            {"Creanga", "Ion", "IS21Z", "Da"},
            {"Turcanu", "Tudor", "IS21Z", "Da"},
            {"Lungu", "Andrei", "IS21Z", "Nu"},
            {"Bazaochi", "Dumitru", "IS21Z", "Da"},
            {"Popov", "Marinela", "IS21Z", "Da"},
            {"Popov", "Dumitru", "IS21Z", "Da"},
            {"Eminescu", "MIhai", "IS21Z", "Nu"}
    };

    List<CellStringValueModel> stringValueList = new ArrayList<>();
    List<CellNumericValueModel> numericValueList = new ArrayList<>();
    List<TXTFileModel> textFileList = new ArrayList<TXTFileModel>();
}