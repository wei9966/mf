package mf_offer_system.springboot_02.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Create By WeiBin on 2020/5/14 19:43
 *
 * @author WB
 */
@Component
@Slf4j
@Aspect
public class MyAspect {

    @Pointcut("execution(* mf_offer_system.springboot_02.service.impl.*.*(..))||execution(* mf_offer_system.springboot_02.controller.*.*(..))")
    public void point() {

    }

    /**
     * 配置异常
     *
     * @param joinPoint
     * @param throwable
     */
    @AfterThrowing(value = "point()", throwing = "throwable")
    public void logThrow(JoinPoint joinPoint, Throwable throwable) {
        log.error("方法" + joinPoint.getSignature().getName() + "出错了" + "异常是" + throwable.getMessage());
    }
}
