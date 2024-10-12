package com.qyrsglxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

// 对应员工信息表
@Mapper
public interface YgMapper {

    // 通过员工id查询员工信息
    public Map<String, Object> getYgById(@Param("id") String id);

    // 通过员工bh查询员工信息
    public Map<String, Object> getYgBybh(@Param("bh") String bh);
    // 查询全部员工的数量
    public Integer getYgListTotal();
    // 通过员工的编号查询员工的数量
    public Integer getYgTotalByBh(@Param("bh") String bh);
    // 分页查询员工信息列表
    public List<Map<String, Object>> getYgListPage(
            @Param("start") Integer start, @Param("length") Integer length);

    // 插入员工信息
    public Integer insertYg(@Param("id") String id, @Param("bh") String bh,
                            @Param("xm") String xm, @Param("xb") String xb,
                            @Param("csrq") String csrq, @Param("rzrq") String rzrq,
                            @Param("bmid") String bmid, @Param("gwid") String gwid);
    // 通过员工id查询员工信息，用于员工编辑
    public Map<String, Object> getYgByIdForUpdate(@Param("id") String id);
    public Integer getYgByIdForUpdate2(@Param("id") String id, @Param("xm") String xm);
//    // 通过员工bh查询员工信息，用于员工编辑
//    public Map<String, Object> getYgBybhForUpdate(@Param("bh") String bh);
    // 通过员工id删除员工信息
    public Integer deleteYgById(@Param("id") String id);

}