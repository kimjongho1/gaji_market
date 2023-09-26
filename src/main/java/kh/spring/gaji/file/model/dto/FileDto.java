package kh.spring.gaji.file.model.dto;
import lombok.Data;

import org.springframework.stereotype.Component;

@Component
@Data
public class FileDto { //변경해야함.
    private String url;
    private int goodsId;
}