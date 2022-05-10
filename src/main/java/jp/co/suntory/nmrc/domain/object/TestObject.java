package jp.co.suntory.nmrc.domain.object;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestObject {
    
    private Integer id;

    private String description;

}
