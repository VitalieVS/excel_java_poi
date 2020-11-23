package options;

import java.io.*;
import java.util.Scanner;

public class ReadTextFile {
    File file;

    public ReadTextFile(File file) {
        this.file = file;
    }

    public void readFile() throws FileNotFoundException {
        int elementNumber = 0;

        try {
            Scanner s = new Scanner(new File(String.valueOf(this.file)));

            while (s.hasNext()) {
                System.out.println("word:" + s.next());
                switch (elementNumber) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
                elementNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error accessing input file!");
        }
    }
}
