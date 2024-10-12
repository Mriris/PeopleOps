package com.qyrsglxt.controller;

import com.qyrsglxt.mapper.GwMapper;
import com.qyrsglxt.util.IdUtil;
import com.qyrsglxt.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 岗位Controller
@RestController
public class GwController {

    @Autowired
    GwMapper gwMapper;

    // 岗位详细信息
    // http://127.0.0.1:8083/backend/gwDetail?id=00206046f839450bb7667e87767c98aa
    @RequestMapping("/gwDetail")
    public Map<String, Object> gwDetail(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = gwMapper.getGwById(id); // 返回结果
        return map;
    }

    // http://127.0.0.1:8083/backend/gwDetail2?id=00206046f839450bb7667e87767c98aa
    @RequestMapping("/gwDetail2")
    public Map<String, Object> gwDetail2(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = gwMapper.getGwById2(id); // 返回结果
        return map;
    }

    // http://127.0.0.1:8083/backend/gwDetailbh?bh=GW001
    @RequestMapping("/gwDetailbh")
    public Map<String, Object> gwDetailbh(String bh) {
        System.out.println("前端传来的编号为" + bh);
        // 从数据库中取数据
        Map<String, Object> map = gwMapper.getGwByBh(bh); // 返回结果
        return map;
    }

    // 岗位
    // http://127.0.0.1:8083/backend/gwList?page=1&pageSize=5
    @RequestMapping("/gwList")
    public Map<String, Object> gwList(Integer page, Integer pageSize) {
        System.out.println("前端传来的page为" + page);
        System.out.println("前端传来的pageSize为" + pageSize);
        // 从数据库中取数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer total = gwMapper.getGwListTotal();
        List<Map<String, Object>> list = null;
        if (total > 0) {
            Integer start = PageUtil.getStart(page, pageSize);
            list = gwMapper.getGwListPage(start, pageSize);
        }
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    // 新建岗位
    // http://127.0.0.1:8083/backend/gwBuild?bh=GW002&mc=市场专员&lx=3
    @RequestMapping("/gwBuild")
    public Map<String, Object> gwBuild(String bh, String mc, String gwlx) {
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的mc为" + mc);
        System.out.println("前端传来的lx为" + gwlx);
        String id = IdUtil.getId();
        // 向数据库中存入数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer res = gwMapper.insertGw(id, bh, mc, gwlx);
        map.put("res", res);
        return map;
    }

    // 编辑岗位
    // http://127.0.0.1:8083/backend/gwUpdate?id=8bfd4bbdaf694cfd994605dd1854cf7b&bh=GW002&mc=市场经理&lx=1
    @RequestMapping("/gwUpdate")
    public Map<String, Object> gwUpdate(String id, String bh, String mc, String gwlx) {
        System.out.println("前端传来的id为" + id);
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的mc为" + mc);
        System.out.println("前端传来的lx为" + gwlx);
        // 向数据库中更新数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer res = gwMapper.updateGwById(id, bh, mc, gwlx);
        map.put("res", res);
        return map;
    }

    // 删除岗位
    // http://127.0.0.1:8083/backend/gwDelete?id=123
    @RequestMapping("/gwDelete")
    public Map<String, Object> gwDelete(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中删除数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer res = gwMapper.deleteGwById(id);
        map.put("res", res);
        return map;
    }
}
