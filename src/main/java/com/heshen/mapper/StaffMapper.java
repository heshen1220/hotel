package com.heshen.mapper;

import com.heshen.dto.Check;
import com.heshen.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StaffMapper {
    List<Staff> getStaff();

    Staff getStaffByPhone(String phone);
}
