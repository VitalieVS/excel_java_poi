package data;

public class CellStringValueData {
    String data;
    int rowIndex;
    int columnIndex;

    public CellStringValueData(String data, int rowIndex, int columnIndex) {
        this.data = data;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public String getRowData() {
        return this.data;
    }
}
