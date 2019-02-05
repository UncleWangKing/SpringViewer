package com.zdpang.springviewer;

import com.zdpang.springviewer.config.SpringViewerConfig;
import com.zdpang.springviewer.context.SpringViewerContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringViewerAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(SpringViewerConfig.class)
    SpringViewerConfig config (){
        return  new SpringViewerConfig("dp", "keep");
    }
}