package com.yqsh.service.impl;

import com.yqsh.service.SetPropertiesServise;
import com.yqsh.vo.PropertiesVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017-02-17.
 */
@Service("setPropertiesService")
public class SetPropertirsServiceImpl implements SetPropertiesServise {
    private static final Logger log = Logger.getLogger(SetPropertirsServiceImpl.class);
    @Override
    public Map<String, Object> getProperties(String url) {
        Map<String, Object> map = new HashMap<>();
        Properties prop = new Properties();
        try {
            File baseFile = new File(url+"\\webapps\\AIOCP\\WEB-INF\\classes");
            if(!baseFile.exists()){
                throw new FileNotFoundException(baseFile.getAbsolutePath()+"系统找不到指定的路径.");
            }
            File fileConfig = getFile(url+"\\webapps\\AIOCP\\WEB-INF\\classes\\config.properties");
            File fileLog = getFile(url+"\\webapps\\AIOCP\\WEB-INF\\classes\\log4j.properties");
            File fileTR = getFile(url+"\\webapps\\AIOCP\\WEB-INF\\classes\\thirdrecharge.properties");

            map.put("jdbcvo",getPropertiesValue(fileConfig,"jdbc.driver","jdbc.url","jdbc.user","jdbc.password","jdbc.initialSize","jdbc.maxActive","jdbc.minIdle","jdbc.maxIdle",
                    "jdbc.validationQuery","jdbc.testOnBorrow","jdbc.testOnReturn","jdbc.testWhileIdle","jdbc.timeBetweenEvictionRunsMillis","jdbc.numTestsPerEvictionRun",
                    "jdbc.removeAbandoned","jdbc.removeAbandonedTimeout","jdbc.maxWait","jdbc.defaultAutoCommit","jdbc.logAbandoned"));
            map.put("logvo",getPropertiesValue(fileLog,"log4j.appender.DATABASE.driver","log4j.appender.DATABASE.URL","log4j.appender.DATABASE.user","log4j.appender.DATABASE.password"));
            map.put("thirdrechargevo",getPropertiesValue(fileTR,"md5Key","desKey","csPolling","csPay"));


        } catch (FileNotFoundException e) {
            log.error("=== getProperties method error 系统找不到指定的路径 ===");
            map.put("errorMessage","系统找不到指定的路径.");
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public File getFile(String url){
        File file = new File(url);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public Map<String, String> getPropertiesValue(File file, String... keys){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        for (String key:keys
             ) {

            String value = prop.getProperty(key);
            /*int pos = StringUtils.lastIndexOf(key,".");
            if(pos!=-1){
                key = key.substring(pos+1);
            }*/
            if(StringUtils.isNotBlank(value))
                map.put(key,value);
        }
        return map;
    }

    @Override
    public Map<String, String> saveProperties(PropertiesVo properties) {
        Map<String, String > map = new HashMap<>();
        File fileConfig = getFile(properties.getUrl()+"\\webapps\\AIOCP\\WEB-INF\\classes\\config.properties");
        File fileLog = getFile(properties.getUrl()+"\\webapps\\AIOCP\\WEB-INF\\classes\\log4j.properties");
        File fileTR = getFile(properties.getUrl()+"\\webapps\\AIOCP\\WEB-INF\\classes\\thirdrecharge.properties");
        try {
            writeData(fileConfig, "jdbc.driver", properties.getJdbcDriver());
            writeData(fileConfig, "jdbc.url", properties.getJdbcUrl());
            writeData(fileConfig, "jdbc.user", properties.getJdbcUser());
            writeData(fileConfig, "jdbc.password", properties.getJdbcPassword());
            writeData(fileConfig, "jdbc.initialSize", properties.getJdbcInitialSize());
            writeData(fileConfig, "jdbc.maxActive", properties.getJdbcMaxActive());
            writeData(fileConfig, "jdbc.minIdle", properties.getJdbcMinIdle());
            writeData(fileConfig, "jdbc.maxIdle", properties.getJdbcMaxIdle());
            writeData(fileConfig, "jdbc.validationQuery", properties.getJdbcValidationQuery());
            writeData(fileConfig, "jdbc.testOnBorrow", properties.getJdbcTestOnBorrow());
            writeData(fileConfig, "jdbc.testOnReturn", properties.getJdbcTestOnReturn());
            writeData(fileConfig, "jdbc.testWhileIdle", properties.getJdbcTestWhileIdle());
            writeData(fileConfig, "jdbc.timeBetweenEvictionRunsMillis", properties.getJdbcTimeBetweenEvictionRunsMillis());
            writeData(fileConfig, "jdbc.numTestsPerEvictionRun", properties.getJdbcNumTestsPerEvictionRun());
            writeData(fileConfig, "jdbc.removeAbandoned", properties.getJdbcRemoveAbandoned());
            writeData(fileConfig, "jdbc.removeAbandonedTimeout", properties.getJdbcRemoveAbandonedTimeout());
            writeData(fileConfig, "jdbc.maxWait", properties.getJdbcMaxWait());
            writeData(fileConfig, "jdbc.defaultAutoCommit", properties.getJdbcDefaultAutoCommit());
            writeData(fileConfig, "jdbc.logAbandoned", properties.getJdbcLogAbandoned());

            writeData(fileLog, "log4j.appender.DATABASE.driver", properties.getLogDriver());
            writeData(fileLog, "log4j.appender.DATABASE.URL", properties.getLogUrl());
            writeData(fileLog, "log4j.appender.DATABASE.user", properties.getLogUser());
            writeData(fileLog, "log4j.appender.DATABASE.password", properties.getLogPassword());

            if(StringUtils.isNotBlank(properties.getCsPay()))writeData(fileTR, "csPay", properties.getCsPay());
            if(StringUtils.isNotBlank(properties.getCsPolling()))writeData(fileTR, "csPolling", properties.getCsPolling());
            if(StringUtils.isNotBlank(properties.getDesKey()))writeData(fileTR, "desKey", properties.getDesKey());
            if(StringUtils.isNotBlank(properties.getMd5Key()))writeData(fileTR, "md5Key", properties.getMd5Key());
        } catch (IOException e) {
            log.error("=== saveProperties method error ===");
            map.put("msg","修改失败");
            return map;
        }

        map.put("msg","修改成功");
        return map;
    }

    public static void writeData(File file, String key, String value) throws IOException {
        Properties prop = new Properties();
            if (!file.exists())
                file.createNewFile();
            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            //一定要在修改值之前关闭fis
            fis.close();
            OutputStream fos = new FileOutputStream(file);
            prop.setProperty(key, value);
            //保存，并加入注释
            prop.store(fos, "Update '" + key + "' value");
            fos.close();
    }
}
