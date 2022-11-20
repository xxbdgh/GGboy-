package cn.com.xjh.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.logging.Logger;

@Component
@Aspect
public class ServiceAspect {
    private Logger logger = Logger.getLogger(ServiceAspect.class.getName());

    @Pointcut("execution(* cn.com.xjh.test.service..*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object txAround(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        try {
            logger.info("开启事务");
            //开启事务
            TransactionUtils.startTransaction();
            proceed = joinPoint.proceed();
            //提交事务
            logger.info("提交事务");
            TransactionUtils.commitTransaction();
            TransactionUtils.close();
        } catch (Throwable throwable) {
            try {
                //发生异常回滚
                TransactionUtils.rollBackTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwable.printStackTrace();
        }

        return proceed;

    }
}

