
package com.example.datasource.aspect;


import com.example.datasource.config.DataSource;
import com.example.datasource.config.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源AOP切面处理
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 切点: 所有配置 DataSource 注解的方法
     */
    @Pointcut("@annotation(com.example.datasource.config.DataSource)")
    public void dataSourcePointCut() {}
    
//    @Pointcut("execution(* com.leo.modules.flow.service..*.*(..))")
//    private void dbflowAspect() {
//    }
//    @Pointcut("execution(* com.leo.modules.flow.dao..*.*(..))")
//  private void dbflowAspectDao() {
//  }
//  
//    @Before("dbflowAspect()" )
//    public void flow (JoinPoint joinPoint) {
//    	logger.info("切换到dbflow 数据源...");
//        DynamicDataSource.setDataSource("flow");
//    }
//    @Before("dbflowAspectDao()" )
//    public void flow1 (JoinPoint joinPoint) {
//    	logger.info("切换到dbflow 数据源...");
//        DynamicDataSource.setDataSource("flow");
//    }
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        // 通过判断 DataSource 中的值来判断当前方法应用哪个数据源
        DynamicDataSource.setDataSource(ds.value());
        System.out.println("当前数据源: " + ds.value());
        logger.debug("set datasource is " + ds.value());
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}