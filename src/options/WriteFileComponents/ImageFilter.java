package options.WriteFileComponents;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFilter extends FileFilter {
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            return extension.equals(Utils.xls)
                    || extension.equals(Utils.xlsx)
                    || extension.equals(Utils.txt);
        }

        return false;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
