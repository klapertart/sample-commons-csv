package klapertart.lab.commonscsv;

import lombok.Builder;
import lombok.Data;

/**
 * @author TRITRONIK-PC_10040
 * @since 13/03/2023
 */

@Data
@Builder
public class Syslog {
    private String level;
    private String timestamp;
    private String source;
    private String application;
    private String message;
}
