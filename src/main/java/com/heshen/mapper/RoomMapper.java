package com.heshen.mapper;

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

}
