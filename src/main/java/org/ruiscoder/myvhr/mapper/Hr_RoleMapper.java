package org.ruiscoder.myvhr.mapper;

import org.ruiscoder.myvhr.model.Hr_Role;

public interface Hr_RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr_Role record);

    int insertSelective(Hr_Role record);

    Hr_Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr_Role record);

    int updateByPrimaryKey(Hr_Role record);
}
