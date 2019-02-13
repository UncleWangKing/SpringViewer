package com.zdpang.springviewer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com.zdpang.springviewer")
public class SpringViewerProperties {

    private String[] controller;
    private String[] service;
    private String[] dao;

    public String[] getController() {
        return controller;
    }

    public void setController(String[] controller) {
        this.controller = controller;
    }

    public String[] getService() {
        return service;
    }

    public void setService(String[] service) {
        this.service = service;
    }

    public String[] getDao() {
        return dao;
    }

    public void setDao(String[] dao) {
        this.dao = dao;
    }
}