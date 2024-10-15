package com.qyrsglxt.controller;

import com.qyrsglxt.mapper.YgMapper;
import com.qyrsglxt.util.IdUtil;
import com.qyrsglxt.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    // http://127.0.0.1:8083/backend/ygDetail?id=8bfd4bbdaf694cfd994605dd1854cf7b
    @RequestMapping("/ygDetail")
    public Map<String, Object> ygDetail(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = ygMapper.getYgById(id); // 返回结果
        return map;
    }

    // 员工详细信息
    // http://127.0.0.1:8083/backend/ygDetail?id=8bfd4bbdaf694cfd994605dd1854cf7b
    @RequestMapping("/ygDetail2")
    public Map<String, Object> ygDetail2(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = ygMapper.getYgById2(id); // 返回结果
        return map;
    }

    // http://127.0.0.1:8083/backend/ygDetailbh?bh=YG0005
    @RequestMapping("/ygDetailbh")
    public Map<String, Object> ygDetailbh(String bh) {
        System.out.println("前端传来的bm为" + bh);
        // 从数据库中取数据
        Map<String, Object> map = ygMapper.getYgBybh(bh); // 返回结果
        return map;
    }

    // 员工列表
    // http://127.0.0.1:8083/backend/ygList?page=1&pageSize=5
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
    // http://127.0.0.1:8083/backend/ygBuild?bh=YG0009&xm=诸葛亮&xb=1&csrq=2000-01-01&rzrq=2021-01-01&bm=123&gw=456
    @RequestMapping("/ygBuild")
    @ResponseBody
    public Map<String, Object> ygBuild(String bh,String xm,String xb,String csrq, String rzrq,String bm,String gw) {
/*        String bh = (String) data.get("bh");
        String xm = (String) data.get("xm");
        String xb = (String) data.get("xb");
        String csrq = (String) data.get("csrq");
        String rzrq = (String) data.get("rzrq");
        String bm = (String) data.get("bm");  // 部门ID
        String gw = (String) data.get("gw");  // 岗位ID*/

        // 打印接收到的内容，确保正确解析
        System.out.println("前端传来的bh为: " + bh);
        System.out.println("前端传来的xm为: " + xm);
        System.out.println("前端传来的xb为: " + xb);
        System.out.println("前端传来的csrq为: " + csrq);
        System.out.println("前端传来的rzrq为: " + rzrq);
        System.out.println("前端传来的bm为: " + bm);
        System.out.println("前端传来的gw为: " + gw);

        String id = IdUtil.getId();  // 生成唯一ID

        // 返回结果
        Map<String, Object> map = new HashMap<>();
        Integer res = -1;

        // 检查编号是否存在
        Integer total = ygMapper.getYgTotalByBh(bh);
        if (total == 0) {
            // 插入数据
            res = ygMapper.insertYg(id, bh, xm, xb, csrq, rzrq, bm, gw);
        }

        map.put("res", res);
        return map;
    }


    // 编辑员工页面的员工详细信息
    // http://127.0.0.1:8083/backend/ygDetailForUpdate?id=f62012e4abde4efc97518129eafee547
    @RequestMapping("/ygDetailForUpdate")
    public Map<String, Object> ygDetailForUpdate(String id) {
        System.out.println("前端传来的id为" + id);
        // 从数据库中取数据
        Map<String, Object> map = ygMapper.getYgByIdForUpdate(id); // 返回结果;
        return map;
    }

    // 编辑员工
    // http://127.0.0.1:8083/backend/ygUpdate?id=8bfd4bbdaf694cfd994605dd1854cf7b&bh=YG0009&xm=诸葛亮&xb=1&csrq=2000-01-01&rzrq=2021-01-01&bm=123&gw=456
    @RequestMapping("/ygUpdate")
    public Map<String, Object> ygUpdate(String id, String bh, String xm, String xb, String rzrq, String bm, String gw) {
        System.out.println("前端传来的id为" + id);
        System.out.println("前端传来的bh为" + bh);
        System.out.println("前端传来的xm为" + xm);
        System.out.println("前端传来的xb为" + xb);
//        System.out.println("前端传来的csrq为" + csrq);
        System.out.println("前端传来的rzrq为" + rzrq);
        System.out.println("前端传来的bm为" + bm);
        System.out.println("前端传来的gw为" + gw);
        // 向数据库中更新数据
        Map<String, Object> map = new HashMap<String, Object>(); // 返回结果

        Integer res =0;
        // 先判断员工编号是否已经存在
        Integer count = ygMapper.getYgTotalByIdAndBh(id, bh);
        if (count == 0) { // 如果员工编号不存在
             res = ygMapper.setYgByIdForUpdate(id, bh, xm, xb, rzrq, bm, gw); // 返回结果;
//        Integer res = 1;
        }
        else{
            res = -1;
        }
        map.put("res", res);
        return map;
    }

    // 删除员工
    // http://127.0.0.1:8083/backend/ygDelete?id=123
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