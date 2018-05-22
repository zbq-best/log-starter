package com.ikyxxs.log.aop;

import com.alibaba.fastjson.JSON;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class LogInterceptor implements MethodInterceptor {
    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();

        //打印入参
        if (null != invocation.getArguments()) {
            logger.info(methodName + " input: {}", JSON.toJSONString(invocation.getArguments()));
        }

        Object result = invocation.proceed();

        //打印返回值
        if (null != result) {
            logger.info(methodName + " output: {}", JSON.toJSONString(result));
        }

        return result;
    }
}