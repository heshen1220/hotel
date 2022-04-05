package com.heshen.mapper;

import com.heshen.dto.Check;
import com.heshen.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StaffMapper {
    List<Staff> getStaff(Staff staff);

    Staff getStaffByPhone(String phone);

    void addStaff(Staff staff);

    void updatePassword(Staff staff);

    void deleteStaff(Staff staff);
}
