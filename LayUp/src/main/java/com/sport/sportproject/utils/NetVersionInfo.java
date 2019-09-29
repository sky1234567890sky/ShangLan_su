package com.sport.sportproject.utils;


/**
 * Created by 华为 on 2019/7/26.
 */
//@XStreamAlias("DOCUMENT")//这里用到注解(必须写)
public class NetVersionInfo {
    public String version;
    public String url;
    public String description;
    public boolean isforceUpdate;

    public NetVersionInfo(String version, String url, String description, boolean isforceUpdate) {
        this.version = version;
        this.url = url;
        this.description = description;
        this.isforceUpdate = isforceUpdate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsforceUpdate() {
        return isforceUpdate;
    }

    public void setIsforceUpdate(boolean isforceUpdate) {
        this.isforceUpdate = isforceUpdate;
    }

    @Override
    public String toString() {
        return "NetVersionInfo{" +
                "version='" + version + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", isforceUpdate=" + isforceUpdate +
                '}';
    }
}
