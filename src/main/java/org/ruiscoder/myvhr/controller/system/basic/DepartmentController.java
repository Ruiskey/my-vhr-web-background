package org.ruiscoder.myvhr.controller.system.basic;

import org.ruiscoder.myvhr.model.Department;
import org.ruiscoder.myvhr.model.RespBean;
import org.ruiscoder.myvhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartmentsByParentId(-1);
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep) {
        departmentService.addDep(dep);
        if (dep.getResult() == 1) {
            return RespBean.ok("插入成功!", dep);
        }
        return RespBean.error("插入失败!");
    }
}
