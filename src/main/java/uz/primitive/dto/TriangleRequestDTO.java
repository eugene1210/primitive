package uz.primitive.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TriangleRequestDTO {

    @JsonProperty("aside")
    private Double aSide;

    @JsonProperty("bside")
    private Double bSide;

    @JsonProperty("cside")
    private Double cSide;
}
