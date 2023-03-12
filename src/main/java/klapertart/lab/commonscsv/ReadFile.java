package klapertart.lab.commonscsv;

import lombok.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author kurakuraninja
 * @since 12/03/23
 */

@Data
public class ReadFile implements ResourceLoaderAware {

    @Autowired
    private ResourceLoader resourceLoader;

    public void readCSV() throws IOException {
        Resource resource = resourceLoader.getResource("Classpath:/syslog-graylog.csv");
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        CSVParser records = CSVFormat.EXCEL.parse(inputStreamReader);

        for (CSVRecord record: records){
            String level = record.get("level");
            String timestamp = record.get("timestamp");
            String source = record.get("source");
            String application = record.get("application");
            String message = record.get("message");
        }

    }
}
