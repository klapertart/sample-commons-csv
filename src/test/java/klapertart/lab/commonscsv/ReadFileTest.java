package klapertart.lab.commonscsv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author TRITRONIK-PC_10040
 * @since 13/03/2023
 */

@SpringBootTest
public class ReadFileTest {

    @Autowired
    private ReadFile readFile;

    @Test
    public void printOutFile() throws IOException {
        readFile.readCSV();
    }
}
