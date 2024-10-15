package com.qyrsglxt.controller;

import com.qyrsglxt.entity.Admin;
import com.qyrsglxt.mapper.GlyMapper;
import com.qyrsglxt.util.IdUtil;
import com.qyrsglxt.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GlyController {

    @Autowired
    GlyMapper glyMapper;


    // 管理员详细信息
    // http://127.0.0.1:8083/backend/glyDetail?id=123
    @RequestMapping("/glyDetail")
    public Map<String, Object> glyDetail(String id) {
        System.out.println("前端传来的id为" + id);
        Map<String, Object> map = glyMapper.getGlyById(id); // 从数据库中获取数据
        return map;
    }

    // 管理员列表
    // http://127.0.0.1:8083/backend/glyList?page=1&pageSize=5
    @RequestMapping("/glyList")
    public Map<String, Object> glyList(Integer page, Integer pageSize) {
        System.out.println("前端传来的page为" + page);
        System.out.println("前端传来的pageSize为" + pageSize);
        Map<String, Object> map = new HashMap<>();
        Integer total = glyMapper.getGlyListTotal();
        List<Map<String, Object>> list = null;
        if (total > 0) {
            Integer start = PageUtil.getStart(page, pageSize);
            list = glyMapper.getGlyListPage(start, pageSize);
        }
        map.put("total", total);
        map.put("list", list);
        return map;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String zhm = loginData.get("zhm");
        String mm = loginData.get("mm");

        Admin admin = glyMapper.findByZhmAndMm(zhm, mm);
        Map<String, Object> result = new HashMap<>();

        if (admin != null) {
            result.put("success", true);
            result.put("message", "登录成功");
            result.put("qx", 1); // 权限为1表示管理员
            result.put("glylx",admin.getGlylx());
            result.put("gly_id", admin.getId());
            result.put("nc", admin.getNc());
        } else {
            result.put("success", false);
            result.put("message", "账户名或密码错误");
        }
        return result;
    }

    // 注册接口
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> registerData) {
        String zhm = registerData.get("zhm");
        String mm = registerData.get("mm");
        String nc = registerData.get("nc");

        Map<String, Object> result = new HashMap<>();

        // 检查账户名是否已经存在
        Admin existingAdmin = glyMapper.findByZhm(zhm);
        if (existingAdmin != null) {
            result.put("success", false);
            result.put("message", "账户名已存在");
            return result;
        }

        // 生成新的管理员ID
        String id = IdUtil.getId();
        Admin newAdmin = new Admin(id, zhm, mm, nc);
        int insertResult = glyMapper.insertAdmin(newAdmin);

        if (insertResult > 0) {
            result.put("success", true);
            result.put("message", "注册成功");
        } else {
            result.put("success", false);
            result.put("message", "注册失败");
        }

        return result;
    }

    @PostMapping("/changePassword")
    public Map<String, Object> changePassword(@RequestBody Map<String, String> passwordData) {
        String id = passwordData.get("id");
        String ymm = passwordData.get("ymm"); // 原密码
        String xmm = passwordData.get("xmm"); // 新密码

        Map<String, Object> result = new HashMap<>();

        // 验证原密码
        Admin admin = glyMapper.findByIdAndMm(id, ymm);
        if (admin == null) {
            result.put("success", false);
            result.put("message", "原密码错误");
            return result;
        }

        // 更新密码
        int updateResult = glyMapper.updatePasswordById(id, xmm);
        if (updateResult > 0) {
            result.put("success", true);
            result.put("message", "密码修改成功");
        } else {
            result.put("success", false);
            result.put("message", "密码修改失败");
        }

        return result;
    }

    // 删除管理员
    // http://127.0.0.1:8083/backend/glyDelete?id=123
    @DeleteMapping("/glyDelete")
    public Map<String, Object> glyDelete(@RequestParam String id) {
        System.out.println("前端传来的id为" + id);
        Map<String, Object> result = new HashMap<>();
        // 从数据库中删除管理员
        int deleteResult = glyMapper.deleteGlyById(id);
        if (deleteResult > 0) {
            result.put("success", true);
            result.put("message", "删除成功");
        } else {
            result.put("success", false);
            result.put("message", "删除失败或管理员不存在");
        }
        return result;
    }

    // 更新管理员信息
    @PostMapping("/glyUpdate")
    public Map<String, Object> glyUpdate(@RequestBody Map<String, String> updateData) {
        String id = updateData.get("id");
        String zhm = updateData.get("zhm");
        String mm = updateData.get("mm");
        String nc = updateData.get("nc");

        Map<String, Object> result = new HashMap<>();

        // 调用 mapper 方法更新管理员信息
        int updateResult = glyMapper.updateGlyById(id, zhm, mm, nc);
        if (updateResult > 0) {
            result.put("success", true);
            result.put("message", "更新成功");
        } else {
            result.put("success", false);
            result.put("message", "更新失败，可能是管理员不存在");
        }

        return result;
    }
}
