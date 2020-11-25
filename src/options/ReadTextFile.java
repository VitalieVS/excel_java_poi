package options;

import models.CellArrayModelInterface;
import models.TXTFileModel;

import java.io.*;
import java.util.Scanner;

public class ReadTextFile implements CellArrayModelInterface {
    File file;
    public ReadTextFile(File file) {
        this.file = file;
    }

    public void readFile() throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File(String.valueOf(this.file)));
            while (scanner.hasNextLine()) {
                String[] array = scanner.nextLine().split(" ");
                TXTFileModel foo = new TXTFileModel(array);
                textFileList.add(foo);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error accessing input file!");
        }
    }
}
