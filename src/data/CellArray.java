package data;

import java.util.ArrayList;
import java.util.List;

public interface CellArray {
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

    List<CellStringValueData> stringValueList = new ArrayList<>();
    List<CellNumericValueData> numericValueList = new ArrayList<>();
}