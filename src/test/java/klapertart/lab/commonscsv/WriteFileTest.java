package klapertart.lab.commonscsv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author klapertart
 * @since 8/23/2024
 */

@SpringBootTest
@Slf4j
public class WriteFileTest {

    @Test
    void testCreateCsvFile()throws IOException {
        String filePath = "output.csv";
        FileWriter writer = new FileWriter(filePath);

        String[] headers = { "ID", "Name", "Age", "Country" };
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers));

        csvPrinter.printRecord(1, "Ari", 10, "Indonesia");
        csvPrinter.printRecord(2, "Budi", 11, "Indonesia");
        csvPrinter.printRecord(3, "Caca", 10, "Indonesia");

        csvPrinter.flush();

        System.out.println("CSV file created successfully: " + filePath);
    }
}
