package com.qyrsglxt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

// 对应岗位信息表
@Mapper
public interface GwMapper {

    // 通过岗位id查询岗位信息
    public Map<String, Object> getGwById(@Param("id") String id);

    public Map<String, Object> getGwById2(@Param("id") String id);

    // 通过岗位编号bh查询岗位信息
    public Map<String, Object> getGwByBh(@Param("bh") String bh);

    // 查询全部岗位的数量
    public Integer getGwListTotal();

    // 分页查询岗位信息列表
    public List<Map<String, Object>> getGwListPage(
            @Param("start") Integer start, @Param("length") Integer length);

    // 插入岗位信息
    public Integer insertGw(@Param("id") String id, @Param("bh") String bh,
                            @Param("mc") String mc, @Param("gwlx") String gwlx);

    // 更新岗位信息
    public Integer updateGwById(@Param("id") String id, @Param("bh") String bh,
                                @Param("mc") String mc, @Param("gwlx") String gwlx);

    // 通过岗位id删除岗位信息
    public Integer deleteGwById(@Param("id") String id);
}
