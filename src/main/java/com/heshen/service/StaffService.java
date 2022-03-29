package com.heshen.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshen.Utils.IPUtils;
import com.heshen.Utils.ShaUtils;
import com.heshen.Utils.TokenUtils;
import com.heshen.config.ResultBody;
import com.heshen.dto.Check;
import com.heshen.entity.Staff;
import com.heshen.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffMapper mapper;

    public ResultBody getStaff(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Staff> GuestroomList = mapper.getStaff();
        PageInfo<Staff> pageResult = new PageInfo<>(GuestroomList);
        return ResultBody.success(pageResult);
    }

    public ResultBody check(Check check , HttpServletRequest httpServletRequest) {
        ShaUtils utils = new ShaUtils();
        Staff staff = mapper.getStaffByPhone(check.getPhone());
        if (staff==null){
            return ResultBody.error("400","账号或密码错误");
        }
        String sha = utils.SHA(check.getPassword());
        if (sha==null||sha.length()<1||!sha.equals(staff.getPassword())){
            return ResultBody.error("400","账号或密码错误");
        }
        String ipAddress = IPUtils.getVisitorIp(httpServletRequest);
        staff.setToken(TokenUtils.getToken(staff.getPhone(),ipAddress));
        return ResultBody.success(staff);
    }
}
