package com.qyrsglxt.mapper;

import com.qyrsglxt.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GlyMapper {

    // 查询管理员账号和密码
    Admin findByZhmAndMm(@Param("zhm") String zhm, @Param("mm") String mm);

    Admin findByIdAndMm(@Param("id") String id, @Param("mm") String mm);

    // 更新管理员密码
    int updatePasswordById(@Param("id") String id, @Param("newPassword") String newPassword);

    // 根据账户名查询管理员
    Admin findByZhm(@Param("zhm") String zhm);

    // 插入新的管理员
    int insertAdmin(Admin admin);

    // 查询管理员列表（分页）
    List<Map<String, Object>> getGlyListPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    // 获取管理员总数
    Integer getGlyListTotal();

    // 根据id获取管理员详细信息
    Map<String, Object> getGlyById(@Param("id") String id);

    // 根据id更新管理员信息
    int updateGlyById(@Param("id") String id, @Param("zhm") String zhm, @Param("mm") String mm,@Param("nc") String nc);

    // 根据id删除管理员
    int deleteGlyById(@Param("id") String id);
}
