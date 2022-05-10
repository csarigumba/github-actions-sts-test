package jp.co.suntory.nmrc.domain.repository;

import jp.co.suntory.nmrc.domain.object.TestObject;

public interface TestObjectRepository {
    
    TestObject save(TestObject testObject);
    
}
