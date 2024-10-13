package com.qyrsglxt.mapper;

import com.qyrsglxt.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GlyMapper {

    // 使用MyBatis的注解方式查询管理员账号和密码
    Admin findByZhmAndMm(@Param("zhm") String zhm, @Param("mm") String mm);
}
