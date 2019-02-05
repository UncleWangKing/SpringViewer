package com.zdpang.springviewer.parser;

import com.zdpang.springviewer.bean.ClassBean;

public class ClassBeanParser {
    public static ClassBean getByanno(Class clazz){
        ClassBean classBean = new ClassBean();
        classBean.setClazz(clazz);
        return classBean;
    }
}
