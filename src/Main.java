import org.junit.Test;

import java.io.IOException;

public class Main {
    @Test
    public void writeFile() throws IOException {
        WriteFile writer = new WriteFile();
        writer.write();
    }
}
