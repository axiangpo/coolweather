package com.example.administrator.coolweather.util;

import android.text.TextUtils;

import com.example.administrator.coolweather.db.City;
import com.example.administrator.coolweather.db.Country;
import com.example.administrator.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class Utility {

    public static boolean handleProvinceResponse(String response)
    {
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allProvinces = new JSONArray(response);
                for(int i =0;i<allProvinces.length();i++)
                {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return  true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
            }
            return false;
        }

    public static boolean handleCityResponse(String response,int provinceId)
    {
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allCities = new JSONArray(response);
                for(int i =0;i<allCities.length();i++)
                {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return  true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountryResponse(String response,int cityId)
    {
        if(!TextUtils.isEmpty(response))
        {
            try{
                JSONArray allCountries = new JSONArray(response);
                for(int i =0;i<allCountries.length();i++)
                {
                    JSONObject contryObject = allCountries.getJSONObject(i);
                    Country contry = new Country();
                    contry.setCountryName(contryObject.getString("name"));
                    contry.setWeatherId(contryObject.getString("weather_id"));
                    contry.setCityId(cityId);
                    contry.save();
                }
                return  true;
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
