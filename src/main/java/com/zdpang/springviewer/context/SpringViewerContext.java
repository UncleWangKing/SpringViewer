package com.zdpang.springviewer.context;

import com.zdpang.springviewer.bean.ClassBean;
import com.zdpang.springviewer.parser.ClassBeanParser;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@Component
public class SpringViewerContext implements ApplicationContextAware{
    private List<ClassBean> controllerClassBeans = new LinkedList<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        /**
         * 根据类注解删选类对象
         */
        for (String name:beanDefinitionNames) {
            Object bean = applicationContext.getBean(name);
            if(null != bean) {
                ClassBean byClassAnno = ClassBeanParser.getByClassAnno(bean.getClass(), RestController.class);
                if (null != byClassAnno) {
                    controllerClassBeans.add(byClassAnno);
                }
            }
        }
    }

    public List<ClassBean> getControllerClassBeans(){
        return controllerClassBeans;
    }
}
