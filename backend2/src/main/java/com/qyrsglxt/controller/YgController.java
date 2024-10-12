package com.qyrsglxt.controller;

import com.qyrsglxt.mapper.YgMapper;
import com.qyrsglxt.util.IdUtil;
import com.qyrsglxt.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 员工Controller
@RestController
public class YgController {

    @Autowired
    YgMapper ygMapper;

    // 员工详细信息
    // http://127.0.0.1:8081/backend/ygDetail?id=8bfd4bbdaf694cfd994605dd1854cf7b
    @RequestMapping("/ygDetail")
    public Map<String, Object> ygDetail(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = ygMapper.getYgById(id); // 返回结果
        return map;
    }

    // 员工列表
    // http://127.0.0.1:8081/backend/ygList?page=1&pageSize=5
    @RequestMapping("/ygList")
    public Map<String, Object> ygList(Integer page, Integer pageSize) {
        System.out.println("前端传来的page为" + page);
        System.out.println("前端传来的pageSize为" + pageSize);
        // 从数据库中取数据
        Map<String, Object> map = new HashMap<String, Object>(); // 返回结果
        Integer total = ygMapper.getYgListTotal();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (total > 0) {
            Integer start = PageUtil.getStart(page, pageSize);
            list = ygMapper.getYgListPage(start, pageSize);
        }
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    // 新建员工
    // http://127.0.0.1:8081/backend/ygBuild?bh=YG0009&xm=诸葛亮&xb=1&csrq=2000-01-01&rzrq=2021-01-01&bm=123&gw=456
    @RequestMapping("/ygBuild")
    public Map<String, Object> ygBuild(String bh, String xm, String xb, String csrq, String rzrq, String bm, String gw) {
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的xm为" + xm);
        System.out.println("前端传来的xb为" + xb);
        System.out.println("前端传来的csrq为" + csrq);
        System.out.println("前端传来的rzrq为" + rzrq);
        System.out.println("前端传来的bm为" + bm);
        System.out.println("前端传来的gw为" + gw);
        String id = IdUtil.getId();
        // 向数据库中存入数据
        Map<String, Object> map = new HashMap<String, Object>(); // 返回结果
        Integer res = ygMapper.insertYg(id, bh, xm, xb, csrq, rzrq, bm, gw);
        map.put("res", res);
        return map;
    }

    // 编辑员工页面的员工详细信息
    // http://127.0.0.1:8081/backend/ygDetailForUpdate?id=123
    @RequestMapping("/ygDetailForUpdate")
    public Map<String, Object> ygDetailForUpdate(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = new HashMap<String, Object>(); // 返回结果
        map.put("bh", "YG0001");
        map.put("xm", "刘备");
        map.put("xb", "1");
        return map;
    }

    // 编辑员工
    // http://127.0.0.1:8081/backend/ygUpdate?id=8bfd4bbdaf694cfd994605dd1854cf7b&bh=YG0009&xm=诸葛亮&xb=1&csrq=2000-01-01&rzrq=2021-01-01&bm=123&gw=456
    @RequestMapping("/ygUpdate")
    public Map<String, Object> ygUpdate(String id, String bh, String xm, String xb, String csrq, String rzrq, String bm, String gw) {
        System.out.println("前端传来的id为" + id);
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的xm为" + xm);
        System.out.println("前端传来的xb为" + xb);
        System.out.println("前端传来的csrq为" + csrq);
        System.out.println("前端传来的rzrq为" + rzrq);
        System.out.println("前端传来的bm为" + bm);
        System.out.println("前端传来的gw为" + gw);
        // 向数据库中更新数据
        Map<String, Object> map = new HashMap<String, Object>(); // 返回结果
        Integer res = 1;
        map.put("res", res);
        return map;
    }

    // 删除员工
    // http://127.0.0.1:8081/backend/ygDelete?id=123
    @RequestMapping("/ygDelete")
    public Map<String, Object> ygDelete(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中删除数据
        Map<String, Object> map = new HashMap<String, Object>(); // 返回结果
        Integer res = ygMapper.deleteYgById(id);
        map.put("res", res);
        return map;
    }

}