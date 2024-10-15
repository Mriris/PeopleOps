package com.qyrsglxt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LzMapper {

    // 通过离职ID获取离职信息
    Map<String, Object> getLzById(@Param("id") String id);

    Map<String, Object> getLzById2(@Param("id") String id);

    // 通过员工ID获取离职信息
    Map<String, Object> getLzByYgId(@Param("ygid") String ygid);

    // 查询全部离职记录的数量
    Integer getLzListTotal();

    // 分页查询离职信息列表
    List<Map<String, Object>> getLzListPage(@Param("start") Integer start, @Param("length") Integer length);

    // 插入离职信息
    Integer insertLz(@Param("id") String id, @Param("ygid") String ygid, @Param("lzrq") String lzrq, @Param("lzlx") String lzlx);

    // 更新离职信息
    Integer updateLz(@Param("id") String id, @Param("lzrq") String lzrq, @Param("lzlx") String lzlx);

    // 通过员工id删除离职信息
    public Integer deleteLzByYgId(@Param("ygid") String ygid);

    // 删除离职信息
    Integer deleteLzById(@Param("id") String id);
}
