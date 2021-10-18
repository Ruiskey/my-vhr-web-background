package org.ruiscoder.myvhr.service;

import org.ruiscoder.myvhr.mapper.EmployeeMapper;
import org.ruiscoder.myvhr.model.Employee;
import org.ruiscoder.myvhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public RespPageBean getEmployeeByPage(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size);
        Long total = employeeMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
}
