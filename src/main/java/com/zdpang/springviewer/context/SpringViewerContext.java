package com.zdpang.springviewer.context;

import com.zdpang.springviewer.bean.ClassBean;
import com.zdpang.springviewer.parser.ClassBeanParser;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class SpringViewerContext implements ApplicationContextAware{
    private List<ClassBean> controllerClassBeans = new LinkedList<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames) {
            Object bean = applicationContext.getBean(name);
            controllerClassBeans.add(ClassBeanParser.getByanno(bean.getClass()));
        }
    }

    public List<ClassBean> getControllerClassBeans(){
        return controllerClassBeans;
    }
}
