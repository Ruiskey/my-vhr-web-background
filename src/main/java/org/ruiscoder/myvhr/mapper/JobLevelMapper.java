package org.ruiscoder.myvhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.ruiscoder.myvhr.model.JobLevel;

import java.util.List;

public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevels();

    Integer deleteJobLevels(@Param("ids") Integer[] ids);
}
