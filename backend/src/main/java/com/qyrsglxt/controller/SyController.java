package com.qyrsglxt.controller;

import com.qyrsglxt.mapper.SyMapper;
import com.qyrsglxt.util.IdUtil;
import com.qyrsglxt.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 试用期员工Controller
@RestController
public class SyController {

    @Autowired
    SyMapper syMapper;

    // 根据员工ID获取试用期信息
    // http://127.0.0.1:8083/backend/syDetail?ygid=123456
    @RequestMapping("/syDetail")
    public Map<String, Object> syDetail(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = syMapper.getSyById(id); // 返回结果
        return map;
    }

    // 根据员工ID获取试用期信息
    // http://127.0.0.1:8083/backend/syDetail?ygid=123456
    @RequestMapping("/syDetail2")
    public Map<String, Object> syDetail2(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = syMapper.getSyById2(id); // 返回结果
        return map;
    }

    // 根据试用期状态获取试用期员工信息
    // http://127.0.0.1:8083/backend/syDetailByStatus?zt=1
    @RequestMapping("/syDetailByStatus")
    public Map<String, Object> syDetailByStatus(String zt) {
        System.out.println("前端传来的试用期状态为" + zt);
        // 从数据库中取数据
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = syMapper.getSyByStatus(zt);
        map.put("list", list);
        return map;
    }

    // 分页获取试用期员工列表
    // http://127.0.0.1:8083/backend/syList?page=1&pageSize=5
    @RequestMapping("/syList")
    public Map<String, Object> syList(Integer page, Integer pageSize) {
        System.out.println("前端传来的page为" + page);
        System.out.println("前端传来的pageSize为" + pageSize);
        // 从数据库中取数据
        Map<String, Object> map = new HashMap<>();
        Integer total = syMapper.getSyTotal();
        List<Map<String, Object>> list = null;
        if (total > 0) {
            Integer start = PageUtil.getStart(page, pageSize);
            list = syMapper.getSyListPage(start, pageSize);
        }
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    // 新建试用期员工记录
    // http://127.0.0.1:8083/backend/syBuild?bh=123&zt=1&ksrq=2024-01-01&jsrq=2024-04-01
    @RequestMapping("/syBuild")
    public Map<String, Object> syBuild(String bh, String zt, String ksrq, String jsrq) {
        System.out.println("前端传来的ygid为" + bh);
        System.out.println("前端传来的zt为" + zt);
        System.out.println("前端传来的ksrq为" + ksrq);
        System.out.println("前端传来的jsrq为" + jsrq);
        String id = IdUtil.getId();
        // 向数据库中存入数据
        Map<String, Object> map = new HashMap<>();
        Integer res = syMapper.insertSy(id, bh, zt, ksrq, jsrq);
        map.put("res", res);
        return map;
    }

    // 编辑试用期员工记录
    // http://127.0.0.1:8083/backend/syUpdate?id=123&zt=2&ksrq=2024-01-01&jsrq=2024-04-01
    @RequestMapping("/syUpdate")
    public Map<String, Object> syUpdate(String id, String zt, String ksrq, String jsrq) {
        System.out.println("前端传来的id为" + id);
        System.out.println("前端传来的zt为" + zt);
        System.out.println("前端传来的ksrq为" + ksrq);
        System.out.println("前端传来的jsrq为" + jsrq);
        // 向数据库中更新数据
        Map<String, Object> map = new HashMap<>();
        Integer res = syMapper.updateSyById(id, zt, ksrq, jsrq);
        map.put("res", res);
        return map;
    }

    // 删除试用期员工记录
    // http://127.0.0.1:8083/backend/syDelete?id=123
    @RequestMapping("/syDelete")
    public Map<String, Object> syDelete(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中删除数据
        Map<String, Object> map = new HashMap<>();
        Integer res = syMapper.deleteSyById(id);
        map.put("res", res);
        return map;
    }
}
