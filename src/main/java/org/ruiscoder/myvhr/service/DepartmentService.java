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
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }

    public List<Department> getAllDepartmentsWithChildren() {
        return departmentMapper.getAllDepartmentsWithChildren();
    }
}
