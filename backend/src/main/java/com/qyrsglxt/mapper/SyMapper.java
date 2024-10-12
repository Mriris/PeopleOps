package com.qyrsglxt.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

// 对应员工试用期信息表
@Mapper
public interface SyMapper {

    // 通过员工ID查询试用期信息
    public Map<String, Object> getSyById(@Param("id") String id);

    public Map<String, Object> getSyById2(@Param("id") String id);

    // 通过试用期状态查询试用期员工信息
    public List<Map<String, Object>> getSyByStatus(@Param("zt") String zt);

    // 查询全部试用期员工的数量
    public Integer getSyTotal();

    // 分页查询试用期员工信息列表
    public List<Map<String, Object>> getSyListPage(@Param("start") Integer start, @Param("length") Integer length);

    // 插入试用期员工信息
    public Integer insertSy(@Param("id") String id, @Param("ygid") String ygid,
                            @Param("zt") String zt, @Param("ksrq") String ksrq,
                            @Param("jsrq") String jsrq);

    // 更新试用期员工信息
    public Integer updateSyById(@Param("id") String id, @Param("zt") String zt,
                                @Param("ksrq") String ksrq, @Param("jsrq") String jsrq);

    // 通过ID删除试用期员工信息
    public Integer deleteSyById(@Param("id") String id);
}
