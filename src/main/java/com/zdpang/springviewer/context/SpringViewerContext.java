package com.zdpang.springviewer.context;

import com.zdpang.springviewer.bean.ClassBean;
import com.zdpang.springviewer.config.SpringViewerProperties;
import com.zdpang.springviewer.parser.ClassBeanParser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class SpringViewerContext implements ApplicationContextAware{
    private List<ClassBean> controllerClassBeans = new LinkedList<>();
    @Autowired
    private SpringViewerProperties springViewerProperties;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        /**
         * 根据类注解删选类对象
         */
        for (String name:beanDefinitionNames) {
            Object bean = applicationContext.getBean(name);
            if(null != bean) {
                for (String refrence:springViewerProperties.getController()) {
                    try {
                        Class<?> annoClass = Class.forName(refrence);
                        ClassBean controllerBean = ClassBeanParser.getByClassAnno(bean.getClass(), annoClass);
                        if (null != controllerBean) {
                            controllerClassBeans.add(controllerBean);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public List<ClassBean> getControllerClassBeans(){
        return controllerClassBeans;
    }
}
