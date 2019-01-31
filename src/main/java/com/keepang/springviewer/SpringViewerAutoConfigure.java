package com.keepang.springviewer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(SpringViewerContext.class)
public class SpringViewerAutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    SpringViewerContext exampleService (){
        return  new SpringViewerContext("dp", "keep");
    }

}