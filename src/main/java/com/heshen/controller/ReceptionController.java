package com.heshen.controller;

import com.heshen.config.ResultBody;
import com.heshen.entity.Reception;
import com.heshen.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceptionController {
    @Autowired
    ReceptionService service;

    @PostMapping("/Reception")
    public ResultBody setReception(Reception reception) {
        return ResultBody.success(service.setReception(reception));
    }

    @PostMapping("/getReception")
    public ResultBody getReception(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
                                   ) {
        return service.getReception(pageNum,pageSize);
    }
    @PostMapping("/stateChange")
    public ResultBody stateChange(Reception reception){
        return service.stateChange(reception);
    }
}
