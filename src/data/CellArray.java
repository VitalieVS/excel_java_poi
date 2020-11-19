package data;

import java.util.ArrayList;
import java.util.List;

public interface CellArray {
    List<CellStringValueData> stringValueList = new ArrayList<>();
    List<CellNumericValueData> numericValueList = new ArrayList<>();
}

// for taking cycle

 /* System.out.println("row String data:");
        for (int i = 0; i < stringValueList.size(); i++) {
            System.out.println(stringValueList.get(i).getRowData());
        }

        System.out.println("row Numeric data:");

        for (int i = 0; i < numericValueList.size(); i++) {
            System.out.println(numericValueList.get(i).getNumericData());
        }

       // for (int i = 0; i < clientList.size(); i++) {
          //  System.out.println(clientList);
       // }*/
