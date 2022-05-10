package jp.co.suntory.nmrc.application.resource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jp.co.suntory.nmrc.domain.object.TestObject;
import lombok.Data;

@Data
public class TestObjectRequest {

    @NotNull
    @Size(min = 1, max = 255)
    private String description;
    
    public TestObject toDomainObject() {
        return TestObject.builder()
                .description(this.description)
                .build();
    }

}
