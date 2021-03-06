package com.heshen.controller;

import com.heshen.config.ResultBody;
import com.heshen.entity.Room;
import com.heshen.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    RoomService service;

    @PostMapping("/room")
    public ResultBody getRoom(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                   Room room){
        return service.getRoom(pageNum,pageSize,room);
    }
    @PostMapping("/roomType")
    public ResultBody getRoomType(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                   Room room){
        return service.getRoomType(pageNum,pageSize,room);
    }
    @PostMapping("/setRoom")
    public ResultBody setRoom(Room room){
        return service.setRoom(room);
    }
    @PostMapping("/updateRoom")
    public ResultBody updateRoom(Room room){
        return service.updateRoom(room);
    }
    @PostMapping("/deleteRoom")
    public ResultBody deleteRoom(String uuid){
        return service.deleteRoom(uuid);
    }
    @PostMapping("/updateRoomState")
    public ResultBody updateRoomState(Room room){
        return service.updateRoomState(room);
    }
}
