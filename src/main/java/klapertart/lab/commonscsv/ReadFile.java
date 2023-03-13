package klapertart.lab.commonscsv;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author kurakuraninja
 * @since 12/03/23
 */

@Component
@Data
@Slf4j
public class ReadFile implements ResourceLoaderAware {

    @Autowired
    private ResourceLoader resourceLoader;

    public void readCSV() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/syslog-graylog.csv");
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        CSVParser records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(inputStreamReader);

        for (CSVRecord record: records){
            Syslog syslog = Syslog.builder()
                    .level(record.get("level").toString())
                    .timestamp(record.get("timestamp").toString())
                    .source(record.get("source").toString())
                    .application(record.get("application_name").toString())
                    .message(record.get("message").toString())
                    .build();

            log.info(syslog.toString());
        }
    }
}
