package jp.co.suntory.nmrc.infrastructure.entity;

import java.time.LocalDateTime;
import jp.co.suntory.nmrc.domain.object.TestObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestObjectEntity {

    private Integer id;

    private String description;

    private LocalDateTime createdAt;

    public static TestObjectEntity build(TestObject myBatisTest) {
        return TestObjectEntity.builder()
                .id(myBatisTest.getId())
                .description(myBatisTest.getDescription())
                .build();
    }

    public TestObject toDomainObject() {
        return TestObject.builder()
                .id(this.id)
                .description(this.description)
                .build();
    }

}