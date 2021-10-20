package org.ruiscoder.myvhr.controller.emp;

import org.ruiscoder.myvhr.model.*;
import org.ruiscoder.myvhr.service.*;
import org.ruiscoder.myvhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NationService nationService;

    @Autowired
    PoliticsStatusService politicsStatusService;

    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PositionService positionService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          String keyword) {
        return employeeService.getEmployeeByPage(page, size, keyword);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean editEmp(@RequestBody Employee employee) {
        if (employeeService.editEmp(employee) == 1) {
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败!");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsStatus")
    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsStatusService.getAllPoliticsStatus();
    }

    @GetMapping("/jobLevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        RespBean respBean =  RespBean.build().setStatus(200).setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id) {
        if (employeeService.deleteEmpByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        //查询出所有员工数据
        List<Employee> data = (List<Employee>) employeeService.getEmployeeByPage(null, null, null).getData();
        return POIUtils.employee2Excel(data);
    }




}
