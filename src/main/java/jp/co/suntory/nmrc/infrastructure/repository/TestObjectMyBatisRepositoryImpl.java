package jp.co.suntory.nmrc.infrastructure.repository;

import org.springframework.stereotype.Repository;
import jp.co.suntory.nmrc.domain.object.TestObject;
import jp.co.suntory.nmrc.domain.repository.TestObjectRepository;
import jp.co.suntory.nmrc.infrastructure.entity.TestObjectEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TestObjectMyBatisRepositoryImpl implements TestObjectRepository {

    @NonNull
    private final TestObjectMyBatisRepository testMyBatisRepository;
    
    @Override
    public TestObject save(TestObject testObject) {      
        TestObjectEntity testObjectEntity = TestObjectEntity.build(testObject);
        testMyBatisRepository.create(testObjectEntity);    
        return testObjectEntity.toDomainObject();
    }

}
