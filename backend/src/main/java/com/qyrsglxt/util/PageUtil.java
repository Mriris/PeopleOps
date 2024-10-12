package com.qyrsglxt.util;

public class PageUtil {

    // 分页查询时用的开始位置
    public static Integer getStart(Integer page, Integer pageSize) {
        return (page - 1) * pageSize;
    }
}