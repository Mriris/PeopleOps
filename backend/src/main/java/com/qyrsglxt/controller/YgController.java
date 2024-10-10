package com.qyrsglxt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 员工Controller
@RestController
public class YgController {

    // 员工详细信息
    // http://127.0.0.1:8081/backend/ygDetail?id=123
    @RequestMapping("/ygDetail")
    public Map<String, Object> ygDetail(String id) {
        System.out.println("前端传来的id为" + id);

        // 从数据库中取数据
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("bh", "YG0001");
        map1.put("xm", "刘备用");
        map1.put("xb", "男");
        map1.put("rzrq", "2021-01-01");
        map1.put("bm", "总经理办公室");
        map1.put("gw", "总经理");
        map1.put("csrq", "2000-01-02");



        return map1;
    }

    // 员工列表
    // http://127.0.0.1:8081/backend/ygList?page=1&pageSize=5
    @RequestMapping("/ygList")
    public Map<String, Object> ygList(Integer page, Integer pageSize) {
        System.out.println("前端传来的page为" + page);
        System.out.println("前端传来的pageSize为" + pageSize);

        Map<String, Object> map = new HashMap<String, Object>(); // 返回结果

        // 从数据库中取数据
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", "e235cc4e882f4cf692a393890aeed28b");
        map1.put("bh", "YG0001");
        map1.put("xm", "刘备用");
        map1.put("xb", "男");
        map1.put("rzrq", "2021-01-01");
        map1.put("bm", "总经理办公室");
        map1.put("gw", "总经理");
        map1.put("csrq", "2000-01-02");
        list.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", "3ec0d5c612fa46da963c62cd21a53097");
        map2.put("bh", "YG0002");
        map2.put("xm", "关羽毛");
        map2.put("xb", "男");
        map2.put("rzrq", "2021-01-01");
        map2.put("bm", "人事行政部");
        map2.put("gw", "人事行政经理");
        map2.put("csrq", "2000-01-02");
        list.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("id", "5c9d48960136440b97e518377d9b7e0f");
        map3.put("bh", "YG0003");
        map3.put("xm", "张飞行");
        map3.put("xb", "男");
        map3.put("rzrq", "2021-01-01");
        map3.put("bm", "人事行政部");
        map3.put("gw", "人事主管");
        map3.put("csrq", "2000-01-02");
        list.add(map3);

        map.put("list", list);
        map.put("total", 3);

        return map;
    }

    // 新建员工
    // http://127.0.0.1:8081/backend/ygBuild?bh=YG0009&xm=诸葛亮&xb=1&rzrq=2000-01-01&bm=123&gw=456
    @RequestMapping("/ygBuild")
    public Map<String, Object> ygBuild(String bh, String xm, String xb, String rzrq, String bm, String gw) {
//        System.out.println("前端传来的id为" + id);
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的xm为" + xm);
        System.out.println("前端传来的xb为" + xb);
        System.out.println("前端传来的rzrq为" + rzrq);
        System.out.println("前端传来的bm为" + bm);
        System.out.println("前端传来的gw为" + gw);
        // 向数据库中存入数据
        Integer res = -1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("res", res);
        return map;
    }

    // 编辑员工页面的员工详细信息
    // http://127.0.0.1:8081/backend/ygDetailForUpdate?id=123
    @RequestMapping("/ygDetailForUpdate")
    public Map<String, Object> ygDetailForUpdate(String id) {
        System.out.println("前端传来的id为" + id);

        // 从数据库中取数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bh", "YG0001");
        map.put("xm", "刘备");
        map.put("xb", "1");

        return map;
    }

    // 编辑员工
    // http://127.0.0.1:8081/backend/ygUpdate?id=789&bh=YG0009&xm=诸葛亮&xb=1&rzrq=2000-01-01&bm=123&gw=456
    @RequestMapping("/ygUpdate")
    public Map<String, Object> ygUpdate(String id, String bh, String xm, String xb, String rzrq, String bm, String gw) {
        System.out.println("前端传来的id为" + id);
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的xm为" + xm);
        System.out.println("前端传来的xb为" + xb);
        System.out.println("前端传来的rzrq为" + rzrq);
        System.out.println("前端传来的bm为" + bm);
        System.out.println("前端传来的gw为" + gw);
        // 向数据库中更新数据
        Integer res = 1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("res", res);
        return map;
    }

    // 删除员工
    // http://127.0.0.1:8081/backend/ygDelete?id=123
    @RequestMapping("/ygDelete")
    public Map<String, Object> ygDelete(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中删除数据
        Integer res = 1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("res", res);
        return map;
    }

}
