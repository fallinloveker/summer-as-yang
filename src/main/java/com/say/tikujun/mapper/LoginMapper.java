package com.say.tikujun.mapper;

import com.say.tikujun.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
    int getLogin(@Param("contact") Integer contact, @Param("password") String password);
    int A_getLogin(@Param("contact") Integer contact, @Param("password") String password);
}
