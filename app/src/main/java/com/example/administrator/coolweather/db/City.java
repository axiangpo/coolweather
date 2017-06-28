package com.example.administrator.coolweather.db;


import org.litepal.crud.DataSupport;

public class City extends DataSupport{
    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityNmae() {
        return cityNmae;
    }

    public void setCityNmae(String cityNmae) {
        this.cityNmae = cityNmae;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String cityNmae;
    private int cityCode;
    private int provinceId;
}