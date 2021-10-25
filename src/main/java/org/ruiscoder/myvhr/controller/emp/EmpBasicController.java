package org.ruiscoder.myvhr.controller.emp;

import org.ruiscoder.myvhr.model.*;
import org.ruiscoder.myvhr.service.*;
import org.ruiscoder.myvhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Arrays;
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
                                          Employee employee, Date[] beginDateScope) {
        System.out.println(employee);
        System.out.println(Arrays.toString(beginDateScope));
        return employeeService.getEmployeeByPage(page, size, employee, beginDateScope);
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
        List<Employee> data = (List<Employee>) employeeService.getEmployeeByPage(null, null, null, null).getData();
        return POIUtils.employee2Excel(data);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        //先将文件存起来
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(),
                politicsStatusService.getAllPoliticsStatus(), departmentService.getAllDepartmentsWithChildren(),
                positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        //打印到控制台 测试
        /*for (Employee employee : list) {
            System.out.println(employee);
        }*/
        if (list.size() == employeeService.addEmps(list)) {
            return RespBean.ok("上传成功!");
        }
        return RespBean.ok("上传失败!");
    }
}
