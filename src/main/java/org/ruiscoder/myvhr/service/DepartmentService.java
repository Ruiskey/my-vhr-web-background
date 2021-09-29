package org.ruiscoder.myvhr.service;

import org.ruiscoder.myvhr.mapper.DepartmentMapper;
import org.ruiscoder.myvhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getAllDepartmentsByParentId(Integer pid) {
        return departmentMapper.getAllDepartmentsByParentId(pid);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }
}
