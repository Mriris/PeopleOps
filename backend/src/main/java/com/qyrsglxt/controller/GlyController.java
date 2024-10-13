package com.qyrsglxt.controller;

import com.qyrsglxt.entity.Admin;
import com.qyrsglxt.mapper.GlyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GlyController {

    @Autowired
    GlyMapper glyMapper;

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
            result.put("gly_id", admin.getId());
            result.put("nc", admin.getNc());
        } else {
            result.put("success", false);
            result.put("message", "账户名或密码错误");
        }
        return result;
    }
}
