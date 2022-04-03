package com.heshen.controller;

import cn.hutool.core.collection.CollUtil;
import com.heshen.config.ResultBody;
import com.heshen.entity.OrderChat;
import com.heshen.entity.Room;
import com.heshen.entity.RoomType;
import com.heshen.mapper.ReceptionMapper;
import com.heshen.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EchartsController {
    @Autowired
    RoomMapper mapper;
    @Autowired
    ReceptionMapper receptionMapper;

    @GetMapping("/example")
    public ResultBody get(){
        Map<String,Object> map=new HashMap<>();
        List<RoomType> roomType = mapper.getRoomType();
        ArrayList list = new ArrayList();
        for (RoomType type :roomType){
            list.add(type.getNum());
        }
        map.put("y", list);
        ArrayList arrayList = new ArrayList();
        List<RoomType> stateRoom = mapper.getStateRoom();
        for (RoomType room:stateRoom){
            arrayList.add(room.getNum());
        }
        map.put("z", arrayList);
        return ResultBody.success(map);
    }

    @GetMapping("/orderChart")
    public ResultBody orderChart(){
        Map<String,Object> map=new HashMap<>();
        List<OrderChat> orderChats = receptionMapper.orderChart();

        ArrayList list = new ArrayList();
        Integer total=0;
        Integer totalPrice=0;
        for (OrderChat order :orderChats){
            list.add(order.getCount());
            total+=order.getCount();
            if (order.getTotalPrice()!=null) {
                totalPrice += order.getTotalPrice();
            }
        }
        map.put("x", list);
        map.put("t",total);
        map.put("p",totalPrice);
        return ResultBody.success(map);
    }
}
