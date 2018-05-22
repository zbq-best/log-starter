package com.ikyxxs.log.autoconfigure;

import com.ikyxxs.log.annotation.Log;
import com.ikyxxs.log.aop.LogInterceptor;
import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class LogAutoConfiguration extends AbstractPointcutAdvisor {

    private Logger logger = LoggerFactory.getLogger(LogAutoConfiguration.class);

    private Pointcut pointcut;

    private Advice advice;

    @PostConstruct
    public void init() {
        logger.info("init LogAutoConfiguration start");
        this.pointcut = new AnnotationMatchingPointcut(null, Log.class);
        this.advice = new LogInterceptor();
        logger.info("init LogAutoConfiguration end");
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

}