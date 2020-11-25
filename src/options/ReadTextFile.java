package options;

import models.CellArrayModelInterface;
import models.CellStringValueModel;
import models.TXTFileModel;

import java.io.*;
import java.util.Scanner;

public class ReadTextFile implements CellArrayModelInterface {
    File file;

    public ReadTextFile(File file) {
        this.file = file;
    }

    public void readFile() throws FileNotFoundException {
        String nume = null;
        String prenume = null;
        String grupa = null;
        String bursa = null;

        
        int elementNumber = 0;

        try {
            Scanner s = new Scanner(new File(String.valueOf(this.file)));
            while (s.hasNext()) {
                TXTFileModel  foo = new TXTFileModel();
                if (elementNumber == 4) {
                    elementNumber = 0;
                    textFileList.add(foo);
                }

                switch (elementNumber) {
                    case 0 -> foo.setNume(s.next());
                    case 1 -> foo.setPrenume(s.next());
                    case 2 -> foo.setGrupa(s.next());
                    case 3 -> foo.setBursa(s.next());
                }
                elementNumber++;
            }

        } catch (IOException e) {
            System.out.println("Error accessing input file!");
        }
    }
}
