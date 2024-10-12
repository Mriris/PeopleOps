package com.qyrsglxt.controller;

import com.qyrsglxt.mapper.LzMapper;
import com.qyrsglxt.util.IdUtil;
import com.qyrsglxt.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 员工离职Controller
@RestController
public class LzController {

    @Autowired
    LzMapper lzMapper;

    // 通过离职ID获取离职信息
    // http://127.0.0.1:8083/backend/lzDetail?id=04283b3860c94b2596503a484ae34154
    @RequestMapping("/lzDetail")
    public Map<String, Object> lzDetail(String id) {
        System.out.println("前端传来的id为" + id);
        Map<String, Object> map = lzMapper.getLzById(id);
        return map;
    }

    // 通过离职ID获取离职信息
    // http://127.0.0.1:8083/backend/lzDetail2?id=04283b3860c94b2596503a484ae34154
    @RequestMapping("/lzDetail2")
    public Map<String, Object> lzDetail2(String id) {
        System.out.println("前端传来的id为" + id);
        Map<String, Object> map = lzMapper.getLzById2(id);
        return map;
    }


    // 通过员工ID获取离职信息
    // http://127.0.0.1:8083/backend/lzDetailByYgId?ygid=123
    @RequestMapping("/lzDetailByYgId")
    public Map<String, Object> lzDetailByYgId(String ygid) {
        System.out.println("前端传来的员工id为" + ygid);
        Map<String, Object> map = lzMapper.getLzByYgId(ygid);
        return map;
    }

    // 离职列表分页查询
    // http://127.0.0.1:8083/backend/lzList?page=1&pageSize=5
    @RequestMapping("/lzList")
    public Map<String, Object> lzList(Integer page, Integer pageSize) {
        System.out.println("前端传来的page为" + page);
        System.out.println("前端传来的pageSize为" + pageSize);
        Map<String, Object> map = new HashMap<>();
        Integer total = lzMapper.getLzListTotal();
        List<Map<String, Object>> list = null;
        if (total > 0) {
            Integer start = PageUtil.getStart(page, pageSize);
            list = lzMapper.getLzListPage(start, pageSize);
        }
        map.put("total", total);
        map.put("list", list);
        return map;
    }


    // 插入离职信息
    // http://127.0.0.1:8083/backend/lzInsert?ygid=123&lzrq=2024-05-01&lzlx=1
    @RequestMapping("/lzInsert")
    public Map<String, Object> lzInsert(String ygid, String lzrq, String lzlx) {
        System.out.println("前端传来的ygid为" + ygid);
        String id = IdUtil.getId();
        Integer res = lzMapper.insertLz(id, ygid, lzrq, lzlx);
        Map<String, Object> map = new HashMap<>();
        map.put("res", res);
        return map;
    }

    // 更新离职信息
    // http://127.0.0.1:8083/backend/lzUpdate?id=04283b3860c94b2596503a484ae34154&lzrq=2024-06-01&lzlx=2
    @RequestMapping("/lzUpdate")
    public Map<String, Object> lzUpdate(String id, String lzrq, String lzlx) {
        System.out.println("前端传来的id为" + id);
        Integer res = lzMapper.updateLz(id, lzrq, lzlx);
        Map<String, Object> map = new HashMap<>();
        map.put("res", res);
        return map;
    }

    // 删除离职信息
    // http://127.0.0.1:8083/backend/lzDelete?id=123
    @RequestMapping("/lzDelete")
    public Map<String, Object> lzDelete(String id) {
        System.out.println("前端传来的id为" + id);
        Integer res = lzMapper.deleteLzById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("res", res);
        return map;
    }
}
