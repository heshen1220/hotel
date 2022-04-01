package com.heshen.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshen.config.ResultBody;
import com.heshen.entity.Customer;
import com.heshen.entity.Reception;
import com.heshen.mapper.ReceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReceptionService {
    @Autowired
    ReceptionMapper mapper;

    public ResultBody setReception(Reception reception){
        if (reception.getTime()==null){return ResultBody.error("起始时间为空");}
        String[] split = reception.getTime().split(",");
        String[] s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(split[0])).split(" ");
        reception.setTimeIn(s1[0]+" 15:00:00");
        String[] s2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(split[1])).split(" ");
        reception.setTimeOut(s2[0]+" 12:00:00");
        mapper.setReception(reception);
        return ResultBody.success();
    }
    public ResultBody getReception(int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Reception> ReceptionList = mapper.getReception();
        PageInfo<Reception> pageResult = new PageInfo<>(ReceptionList);
        return ResultBody.success(pageResult);
    }

    public ResultBody stateChange(Reception reception) {
        mapper.stateChange(reception);
        return ResultBody.success();
    }
}
