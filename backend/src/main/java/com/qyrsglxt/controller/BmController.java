package com.qyrsglxt.controller;

import com.qyrsglxt.mapper.BmMapper;
import com.qyrsglxt.util.IdUtil;
import com.qyrsglxt.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 部门Controller
@RestController
public class BmController {

    @Autowired
    BmMapper bmMapper;

    // 部门详细信息
    // http://127.0.0.1:8083/backend/bmDetail?id=8bfd4bbdaf694cfd994605dd1854cf7b
    @RequestMapping("/bmDetail")
    public Map<String, Object> bmDetail(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = bmMapper.getBmById(id); // 返回结果
        return map;
    }

    // http://127.0.0.1:8083/backend/bmDetailbh?bh=BM01
    @RequestMapping("/bmDetailbh")
    public Map<String, Object> bmDetailbh(String bh) {
        System.out.println("前端传来的编号为" + bh);
        // 从数据库中取数据
        Map<String, Object> map = bmMapper.getBmByBh(bh); // 返回结果
        return map;
    }

    // 部门列表
    // http://127.0.0.1:8083/backend/bmList?page=1&pageSize=5
    @RequestMapping("/bmList")
    public Map<String, Object> bmList(Integer page, Integer pageSize) {
        System.out.println("前端传来的page为" + page);
        System.out.println("前端传来的pageSize为" + pageSize);
        // 从数据库中取数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer total = bmMapper.getBmListTotal();
        List<Map<String, Object>> list = null;
        if (total > 0) {
            Integer start = PageUtil.getStart(page, pageSize);
            list = bmMapper.getBmListPage(start, pageSize);
        }
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    // 新建部门
    // http://127.0.0.1:8083/backend/bmBuild?bh=BM02&mc=销售部&dh=123456789&cz=987654321&clrq=2020-01-01
    @RequestMapping("/bmBuild")
    public Map<String, Object> bmBuild(String bh, String mc, String dh, String cz, String clrq) {
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的mc为" + mc);
        System.out.println("前端传来的dh为" + dh);
        System.out.println("前端传来的cz为" + cz);
        System.out.println("前端传来的clrq为" + clrq);
        String id = IdUtil.getId();
        // 向数据库中存入数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer res = bmMapper.insertBm(id, bh, mc, dh, cz, clrq);
        map.put("res", res);
        return map;
    }

    // 编辑部门
    // http://127.0.0.1:8083/backend/bmUpdate?id=8bfd4bbdaf694cfd994605dd1854cf7b&bh=BM02&mc=销售部&dh=123456789&cz=987654321&clrq=2020-01-01
    @RequestMapping("/bmUpdate")
    public Map<String, Object> bmUpdate(String id, String bh, String mc, String dh, String cz, String clrq) {
        System.out.println("前端传来的id为" + id);
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的mc为" + mc);
        System.out.println("前端传来的dh为" + dh);
        System.out.println("前端传来的cz为" + cz);
        System.out.println("前端传来的clrq为" + clrq);
        // 向数据库中更新数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer res = bmMapper.updateBmById(id, bh, mc, dh, cz, clrq);
        map.put("res", res);
        return map;
    }

    // 删除部门
    // http://127.0.0.1:8083/backend/bmDelete?id=123
    @RequestMapping("/bmDelete")
    public Map<String, Object> bmDelete(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中删除数据
        Map<String, Object> map = new HashMap<>(); // 返回结果
        Integer res = bmMapper.deleteBmById(id);
        map.put("res", res);
        return map;
    }

}
