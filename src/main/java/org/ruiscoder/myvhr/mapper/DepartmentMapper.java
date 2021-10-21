package org.ruiscoder.myvhr.mapper;

import org.ruiscoder.myvhr.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer id);

    void addDep(Department dep);

    List<Department> getAllDepartmentsWithChildren();
}
