package com.shevalab.testaop;

import java.util.Collection;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ChangeAwareAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(value = "target(com.shevalab.testaop.ChangeAware) && (execution(* com.shevalab.*.*.get*(..)) || execution(* com.shevalab.*.*.set*(..)))")
    public void after(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
        String name = joinPoint.getSignature().getName();
        ChangeAware changeAware = (ChangeAware) joinPoint.getTarget();
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (name.startsWith("get")) {
            if (isInheriting(methodSignature.getReturnType(), Collection.class)) {
                changeAware.setChange(name.substring(3).toLowerCase());
            }
        } else {
            changeAware.setChange(name.substring(3).toLowerCase());
        }
    }

    private boolean isInheriting(Class inheriting, Class inherited) {
        for(Class clazz : inheriting.getInterfaces()) {
            if(clazz.equals(inherited)) return true;
        }
        return false;
    }
}

