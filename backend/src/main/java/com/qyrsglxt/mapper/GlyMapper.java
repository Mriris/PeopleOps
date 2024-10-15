package com.qyrsglxt.mapper;

import com.qyrsglxt.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GlyMapper {

    // 使用MyBatis的注解方式查询管理员账号和密码
    Admin findByZhmAndMm(@Param("zhm") String zhm, @Param("mm") String mm);

    Admin findByIdAndMm(@Param("id") String id, @Param("mm") String mm);

    // 更新管理员密码
    int updatePasswordById(@Param("id") String id, @Param("newPassword") String newPassword);

    // 根据账户名查询管理员
    Admin findByZhm(@Param("zhm") String zhm);

    // 插入新的管理员
    int insertAdmin(Admin admin);
}
