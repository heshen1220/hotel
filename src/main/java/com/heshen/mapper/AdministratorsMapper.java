package com.heshen.mapper;


import com.heshen.entity.Administrators;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdministratorsMapper {
    List<Administrators> getAdministrators();
}
