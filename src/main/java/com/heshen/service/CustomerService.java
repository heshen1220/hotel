package com.heshen.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshen.config.ResultBody;
import com.heshen.entity.Customer;
import com.heshen.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    public ResultBody getCustomer(int pageNum, int pageSize,Customer customer){
        PageHelper.startPage(pageNum, pageSize);
        List<Customer> customerList = customerMapper.getCustomer(customer);
        PageInfo<Customer> pageResult = new PageInfo<Customer>(customerList);
        return ResultBody.success(pageResult);
    }
}
