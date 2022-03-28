package com.heshen.mapper;

import com.heshen.entity.Reception;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReceptionMapper {
    void setReception(Reception reception);

    List<Reception> getReception();


}
