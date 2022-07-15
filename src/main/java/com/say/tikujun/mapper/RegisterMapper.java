package com.say.tikujun.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterMapper {
    //学生注册
    int getTest(@Param("contact") Integer contact);
    void getRegister(@Param("name_s") String name_s,
                     @Param("contact") Integer contact,
                     @Param("password") String password);

    void updateStudent(@Param("id_s") Integer id_s,
                     @Param("password") String password,
                       @Param("oldpassword") String oldpassword);
    Integer checkUserLoginInfo(@Param("id_s") Integer id_s,
                              @Param("password") String password);
    //管理员注册
    int A_getTest(@Param("contact") Integer contact);
    void A_getRegister(@Param("name_s") String name_s,
                     @Param("contact") Integer contact,
                     @Param("password") String password);
    void updateAdministrator(@Param("id_s") Integer id_s,
                       @Param("password") String password,
                       @Param("oldpassword") String oldpassword);
    Integer checkAdministratorLoginInfo(@Param("id_s") Integer id_s,
                               @Param("password") String password);
}