package com.yqsh.controller;

import com.yqsh.service.SetPropertiesServise;
import com.yqsh.vo.PropertiesVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017-02-16.
 */
@Controller
@RequestMapping("/setProperties")
public class SetPropertiesController {

    @Autowired
    private SetPropertiesServise setPropertiesServise;

    @RequestMapping("toIndex")
    public String toIndex(){
        return "/view/index.html";
    }

    @RequestMapping("getProperties")
    public @ResponseBody
    Map<String, Object> getProperties(String url){

        System.out.println(url+"url");

        return setPropertiesServise.getProperties(url);
    }

    @RequestMapping("saveProperties")
    public @ResponseBody Map<String, String> saveProperties(PropertiesVo properties){
        return setPropertiesServise.saveProperties(properties);
    }

}
