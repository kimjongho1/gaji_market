package kh.spring.gaji.file.model.dto;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
@Data
public class FileDto { //변경해야함.
    private String url;
    private LocalDateTime createdAt;
}