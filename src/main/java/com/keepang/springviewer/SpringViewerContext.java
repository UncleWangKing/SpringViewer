package com.keepang.springviewer;

public class SpringViewerContext {

    private String prefix;
    private String suffix;

    public SpringViewerContext(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }
    public String wrap(String word) {
        return prefix + word + suffix;
    }
}