package jp.co.suntory.nmrc.infrastructure.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import jp.co.suntory.nmrc.infrastructure.entity.TestObjectEntity;

@Mapper
public interface TestObjectMyBatisRepository {
    
    @Insert("INSERT INTO test_objects (description)"
            + " VALUES (#{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(TestObjectEntity testObjectEntity);
    
}
