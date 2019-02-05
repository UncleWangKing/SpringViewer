package com.zdpang.springviewer.config;

public class SpringViewerConfig {

    private String prefix;
    private String suffix;

    public SpringViewerConfig(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }
    public String wrap(String word) {
        return prefix + word + suffix;
    }
}