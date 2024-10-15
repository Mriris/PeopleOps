package com.qyrsglxt.entity;

public class Admin {


    private String id;
    private String zhm;
    private String mm;
    private String nc;
    private String glylx;

    public Admin(){

    }


    public Admin(String id, String zhm, String mm, String nc) {
        this.id = id;
        this.zhm = zhm;
        this.mm = mm;
        this.nc = nc;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZhm() {
        return zhm;
    }

    public void setZhm(String zhm) {
        this.zhm = zhm;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getGlylx() {
        return glylx;
    }

    public void setGlylx(String glylx) {
        this.glylx = glylx;
    }
}
