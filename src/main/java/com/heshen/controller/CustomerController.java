package com.heshen.controller;

import com.heshen.config.ResultBody;
import com.heshen.entity.Customer;
import com.heshen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerService service;
    @PostMapping("/customer")
    public ResultBody getCustomer(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                  Customer customer){
        return service.getCustomer(pageNum,pageSize,customer);

    }
}
