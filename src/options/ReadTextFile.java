package options;

import java.io.File;

public class ReadTextFile {
    File file;

    public ReadTextFile(File file) {
        this.file = file;
    }

    public void readFile(){
        File myObj = new File(String.valueOf(this.file));
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
