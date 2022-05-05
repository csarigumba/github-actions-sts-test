package jp.co.suntory.nmrc.application.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class TestRequest {

    @NotNull
    @Size(min = 1, max = 255)
    private String description;

}
