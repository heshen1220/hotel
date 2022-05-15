package com.heshen.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshen.Utils.IpUtils;
import com.heshen.Utils.ShaUtils;
import com.heshen.Utils.TokenUtils;
import com.heshen.config.ResultBody;
import com.heshen.dto.Check;
import com.heshen.dto.PassWord;
import com.heshen.entity.Staff;
import com.heshen.mapper.StaffMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class StaffService {
    @Resource
    StaffMapper mapper;

    public ResultBody getStaff(int pageNum, int pageSize,Staff staff){
        PageHelper.startPage(pageNum, pageSize);
        List<Staff> GuestroomList = mapper.getStaff(staff);
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
        String ipAddress = IpUtils.getVisitorIp(httpServletRequest);
        staff.setToken(TokenUtils.getToken(staff.getPhone(),ipAddress));
        return ResultBody.success(staff);
    }

    public ResultBody administrators() {
        List<Staff> staff = mapper.getStaff(new Staff());
        return ResultBody.success(staff.size());
    }

    public ResultBody addStaff(Staff staff) {
        ShaUtils utils = new ShaUtils();
        staff.setPassword(utils.SHA(staff.getPassword()));
        mapper.addStaff(staff);
        return ResultBody.success();
    }

    public ResultBody updatePassword(PassWord passWord) {
        ShaUtils utils = new ShaUtils();
        Staff staff =new Staff();
        staff.setId(passWord.getId());
        List<Staff> staff1 = mapper.getStaff(staff);
        if (staff1.size()==0){
            return ResultBody.error("无此用户ID");
        }
        if (!staff1.get(0).getPassword().equals(utils.SHA(passWord.getPassword()))){
            return ResultBody.error("密码输入错误");
        }
        staff.setPassword(utils.SHA(passWord.getNewPassword()));
        mapper.updatePassword(staff);
        return ResultBody.success();
    }

    public ResultBody deleteStaff(Staff staff) {
        mapper.deleteStaff(staff);
        return ResultBody.success();
    }
}
