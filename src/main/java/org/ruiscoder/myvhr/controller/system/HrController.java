package org.ruiscoder.myvhr.controller.system;

import org.ruiscoder.myvhr.model.Hr;
import org.ruiscoder.myvhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @GetMapping("/")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrs();
    }
}
