package com.yqsh.vo;

/**
 * Created by Administrator on 2017-02-17.
 */
public class PropertiesVo {
    private String url;
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;
    private String jdbcInitialSize;
    private String jdbcMaxActive;
    private String jdbcMinIdle;
    private String jdbcMaxIdle;
    private String jdbcValidationQuery;
    private String jdbcTestOnBorrow;
    private String jdbcTestOnReturn;
    private String jdbcTestWhileIdle;
    private String jdbcTimeBetweenEvictionRunsMillis;
    private String jdbcNumTestsPerEvictionRun;
    private String jdbcRemoveAbandoned;
    private String jdbcRemoveAbandonedTimeout;
    private String jdbcMaxWait;
    private String jdbcDefaultAutoCommit;
    private String jdbcLogAbandoned;
    private String logDriver;
    private String logUrl;
    private String logUser;
    private String logPassword;
    private String md5Key;
    private String desKey;
    private String csPolling;
    private String csPay;

    public PropertiesVo() {

    }


    public String getJdbcInitialSize() {
        return jdbcInitialSize;
    }

    public void setJdbcInitialSize(String jdbcInitialSize) {
        this.jdbcInitialSize = jdbcInitialSize;
    }

    public String getJdbcMaxActive() {
        return jdbcMaxActive;
    }

    public void setJdbcMaxActive(String jdbcMaxActive) {
        this.jdbcMaxActive = jdbcMaxActive;
    }

    public String getJdbcMinIdle() {
        return jdbcMinIdle;
    }

    public void setJdbcMinIdle(String jdbcMinIdle) {
        this.jdbcMinIdle = jdbcMinIdle;
    }

    public String getJdbcMaxIdle() {
        return jdbcMaxIdle;
    }

    public void setJdbcMaxIdle(String jdbcMaxIdle) {
        this.jdbcMaxIdle = jdbcMaxIdle;
    }

    public String getJdbcValidationQuery() {
        return jdbcValidationQuery;
    }

    public void setJdbcValidationQuery(String jdbcValidationQuery) {
        this.jdbcValidationQuery = jdbcValidationQuery;
    }

    public String getJdbcTestOnBorrow() {
        return jdbcTestOnBorrow;
    }

    public void setJdbcTestOnBorrow(String jdbcTestOnBorrow) {
        this.jdbcTestOnBorrow = jdbcTestOnBorrow;
    }

    public String getJdbcTestOnReturn() {
        return jdbcTestOnReturn;
    }

    public void setJdbcTestOnReturn(String jdbcTestOnReturn) {
        this.jdbcTestOnReturn = jdbcTestOnReturn;
    }

    public String getJdbcTestWhileIdle() {
        return jdbcTestWhileIdle;
    }

    public void setJdbcTestWhileIdle(String jdbcTestWhileIdle) {
        this.jdbcTestWhileIdle = jdbcTestWhileIdle;
    }

    public String getJdbcTimeBetweenEvictionRunsMillis() {
        return jdbcTimeBetweenEvictionRunsMillis;
    }

    public void setJdbcTimeBetweenEvictionRunsMillis(String jdbcTimeBetweenEvictionRunsMillis) {
        this.jdbcTimeBetweenEvictionRunsMillis = jdbcTimeBetweenEvictionRunsMillis;
    }

    public String getJdbcNumTestsPerEvictionRun() {
        return jdbcNumTestsPerEvictionRun;
    }

    public void setJdbcNumTestsPerEvictionRun(String jdbcNumTestsPerEvictionRun) {
        this.jdbcNumTestsPerEvictionRun = jdbcNumTestsPerEvictionRun;
    }

    public String getJdbcRemoveAbandoned() {
        return jdbcRemoveAbandoned;
    }

    public void setJdbcRemoveAbandoned(String jdbcRemoveAbandoned) {
        this.jdbcRemoveAbandoned = jdbcRemoveAbandoned;
    }

    public String getJdbcRemoveAbandonedTimeout() {
        return jdbcRemoveAbandonedTimeout;
    }

    public void setJdbcRemoveAbandonedTimeout(String jdbcRemoveAbandonedTimeout) {
        this.jdbcRemoveAbandonedTimeout = jdbcRemoveAbandonedTimeout;
    }

    public String getJdbcMaxWait() {
        return jdbcMaxWait;
    }

    public void setJdbcMaxWait(String jdbcMaxWait) {
        this.jdbcMaxWait = jdbcMaxWait;
    }

    public String getJdbcDefaultAutoCommit() {
        return jdbcDefaultAutoCommit;
    }

    public void setJdbcDefaultAutoCommit(String jdbcDefaultAutoCommit) {
        this.jdbcDefaultAutoCommit = jdbcDefaultAutoCommit;
    }

    public String getJdbcLogAbandoned() {
        return jdbcLogAbandoned;
    }

    public void setJdbcLogAbandoned(String jdbcLogAbandoned) {
        this.jdbcLogAbandoned = jdbcLogAbandoned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getLogDriver() {
        return logDriver;
    }

    public void setLogDriver(String logDriver) {
        this.logDriver = logDriver;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getLogPassword() {
        return logPassword;
    }

    public void setLogPassword(String logPassword) {
        this.logPassword = logPassword;
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }

    public String getDesKey() {
        return desKey;
    }

    public void setDesKey(String desKey) {
        this.desKey = desKey;
    }

    public String getCsPolling() {
        return csPolling;
    }

    public void setCsPolling(String csPolling) {
        this.csPolling = csPolling;
    }

    public String getCsPay() {
        return csPay;
    }

    public void setCsPay(String csPay) {
        this.csPay = csPay;
    }
}
