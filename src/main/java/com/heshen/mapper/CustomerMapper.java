package com.heshen.mapper;

import com.heshen.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {
    List<Customer> getCustomer(Customer customer);
}
