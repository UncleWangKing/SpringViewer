package com.zdpang.springviewer.parser;

import com.zdpang.springviewer.bean.ClassBean;

public class ClassBeanParser {
    public static ClassBean getByClassAnno(Class clazz, Class clazzAnno){
        if (clazz.isAnnotationPresent(clazzAnno)) {
            ClassBean classBean = new ClassBean();
            classBean.setClazz(clazz);
            return classBean;
        }
        return null;
    }
}
