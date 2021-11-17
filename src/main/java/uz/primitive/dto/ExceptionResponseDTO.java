package uz.primitive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponseDTO {

    private String status;
    private String error;
    private String message;
    private String timestamp;
}
