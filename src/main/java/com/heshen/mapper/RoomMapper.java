package com.heshen.mapper;

import com.heshen.config.ResultBody;
import com.heshen.entity.Room;
import com.heshen.entity.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoomMapper {
    List<Room> getRoom(Room room);
    List<RoomType> getRoomType(Room room);
    void setRoom(Room room);

    void updateRoom(Room room);

    void deleteRoom(String uuid);
}
