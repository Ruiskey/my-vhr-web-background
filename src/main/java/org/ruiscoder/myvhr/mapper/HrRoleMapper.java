package org.ruiscoder.myvhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.ruiscoder.myvhr.model.Hr_Role;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr_Role record);

    int insertSelective(Hr_Role record);

    Hr_Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr_Role record);

    int updateByPrimaryKey(Hr_Role record);

    Integer addRole(@Param("hrid") Integer hrid,@Param("rids") Integer[] rids);

    void deleteByHrid(Integer hrid);
}
