package com.heshen.controller;

import com.heshen.config.ResultBody;
import com.heshen.dto.Check;
import com.heshen.dto.PassWord;
import com.heshen.entity.Staff;
import com.heshen.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StaffController {
    @Autowired
    StaffService service;
    @PostMapping("/getStaff")
    public ResultBody getStaff(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize,
                               Staff staff){
        return service.getStaff(pageNum,pageSize,staff);
    }
    @PostMapping("/check")
    public ResultBody check(Check check, HttpServletRequest httpServletRequest){
        return service.check(check ,httpServletRequest);
    }
    @GetMapping("/login")
    public ResultBody login(){
        return ResultBody.success();
    }
    @GetMapping("/administrators")
    public ResultBody administrators(){
        return service.administrators();
    }

    @PostMapping("/addStaff")
    public ResultBody addStaff(Staff staff){
        return service.addStaff(staff);
    }

    @PostMapping("/updatePassword")
    public ResultBody updatePassword(PassWord passWord){
        return service.updatePassword(passWord);
    }
    @PostMapping("/deleteStaff")
    public ResultBody deleteStaff(Staff staff){
        return service.deleteStaff(staff);
    }
}
