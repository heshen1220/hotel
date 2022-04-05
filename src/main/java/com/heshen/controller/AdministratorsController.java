package com.heshen.controller;

import com.heshen.config.ResultBody;
import com.heshen.entity.Administrators;
import com.heshen.mapper.AdministratorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdministratorsController {
    @Autowired
    AdministratorsMapper mapper;
    @GetMapping("/Administrators")
    public ResultBody getAdministrators(){
        return ResultBody.success(mapper.getAdministrators());
    }
    @GetMapping("/Reception")
    public ResultBody getReception(){
        List<Administrators> administrators = mapper.getAdministrators();
        administrators.remove(12);
        administrators.remove(11);
        administrators.remove(10);
        administrators.remove(4);
        administrators.remove(2);
        return ResultBody.success(administrators);
    }
}
