package com.app.portfolio.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
@Configuration
@Slf4j
public class LoggingAspectAnnotationDriven {

    @Before("execution(* com.app.portfolio.controllers.QuotesController.handleException(..))")
    public void beforeExceptionHandler(JoinPoint jp) {
        log.info("(beforeExceptionHandler) Before executing '" + jp.getSignature().toLongString() + "'");
    }

    @After("execution(* com.app.portfolio.controllers.QuotesController.handleException(..))")
    public void afterExceptionHandler(JoinPoint jp) {
        log.info("(afterExceptionHandler) Before executing '" + jp.getSignature().toLongString() + "'");
    }

    @Before("execution(* com.app.portfolio.PortfolioApplication.*(..))")
    public void beforeSampleWebUiApplication(JoinPoint jp) {
        log.info("(beforePortfolioApplication) Before executing '" + jp.getSignature().toLongString() + "'");
    }

    @After("execution(* com.app.portfolio.PortfolioApplication.*(..))")
    public void afterSampleWebUiApplication(JoinPoint jp) {
        log.info("(afterPortfolioApplication) After executing '" + jp.getSignature().toLongString() + "'");
    }

}
