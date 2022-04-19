package com.example.system_master_springboot_maven.dao;

import com.example.system_master_springboot_maven.pojo.OldMan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OldManDao {
    int insertOldMan(OldMan oldMan);
    int deleteOldMan(int old_id);
    int updateOldMan(OldMan oldMan);
    OldMan selectOldManById(int old_id);
    List<OldMan> selectAllOldMan();
}
