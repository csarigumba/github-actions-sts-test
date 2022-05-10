package jp.co.suntory.nmrc.domain.service;

import org.springframework.stereotype.Service;
import jp.co.suntory.nmrc.domain.object.TestObject;
import jp.co.suntory.nmrc.domain.repository.TestObjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestObjectService {

    @NonNull
    private final TestObjectRepository testRepository;
    
    public TestObject save(TestObject testObject) {
        return testRepository.save(testObject);
    }
}
