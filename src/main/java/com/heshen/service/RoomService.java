package com.heshen.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heshen.config.ResultBody;
import com.heshen.entity.Room;
import com.heshen.entity.RoomType;
import com.heshen.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomMapper guestroomMapper;
    public ResultBody getRoom(int pageNum, int pageSize,Room room){
        PageHelper.startPage(pageNum, pageSize);
        List<Room> GuestroomList = guestroomMapper.getRoom(room);
        PageInfo<Room> pageResult = new PageInfo<>(GuestroomList);
        return ResultBody.success(pageResult);
    }
    public ResultBody getRoomType(int pageNum, int pageSize,Room room){
        PageHelper.startPage(pageNum, pageSize);
        List<RoomType> GuestroomList = guestroomMapper.getRoomType(room);
        PageInfo<RoomType> pageResult = new PageInfo<>(GuestroomList);
        return ResultBody.success(pageResult);
    }

}
