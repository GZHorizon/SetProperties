package com.yqsh.service;

import com.yqsh.vo.PropertiesVo;

import java.util.Map;

/**
 * Created by Administrator on 2017-02-17.
 */
public interface SetPropertiesServise {

    public Map<String, Object> getProperties(String url);

    public Map<String, String> saveProperties(PropertiesVo properties);
}
