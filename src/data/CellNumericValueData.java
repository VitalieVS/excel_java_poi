package data;

public class CellNumericValueData {
        double data;
        int rowIndex;
        int columnIndex;

    public CellNumericValueData(double data, int rowIndex, int columnIndex) {
        this.data = data;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

        public double getNumericData() {
            return this.data;
        }
}
