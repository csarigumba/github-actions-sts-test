package jp.co.suntory.nmrc.domain.service;

import org.springframework.stereotype.Service;
import jp.co.suntory.nmrc.domain.object.TestObject;
import jp.co.suntory.nmrc.domain.repository.TestObjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestObjectService {

    @NonNull
    private final TestObjectRepository testRepository;
    
    public TestObject save(TestObject testObject) {
        log.info("Saving TestObject into database: testObject={}", testObject);
        TestObject ret = testRepository.save(testObject);
        
        log.info("TestObject save successful: testObject={}", ret);
        return ret;
    }
}
