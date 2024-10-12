package com.qyrsglxt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

// 对应部门信息表
@Mapper
public interface BmMapper {

    // 通过部门id查询部门信息
    public Map<String, Object> getBmById(@Param("id") String id);

    // 通过部门编号bh查询部门信息
    public Map<String, Object> getBmByBh(@Param("bh") String bh);

    // 查询全部部门的数量
    public Integer getBmListTotal();

    // 分页查询部门信息列表
    public List<Map<String, Object>> getBmListPage(
            @Param("start") Integer start, @Param("length") Integer length);

    // 插入部门信息
    public Integer insertBm(@Param("id") String id, @Param("bh") String bh,
                            @Param("mc") String mc, @Param("dh") String dh,
                            @Param("cz") String cz, @Param("clrq") String clrq);

    // 更新部门信息
    public Integer updateBmById(@Param("id") String id, @Param("bh") String bh,
                                @Param("mc") String mc, @Param("dh") String dh,
                                @Param("cz") String cz, @Param("clrq") String clrq);

    // 通过部门id删除部门信息
    public Integer deleteBmById(@Param("id") String id);
}
