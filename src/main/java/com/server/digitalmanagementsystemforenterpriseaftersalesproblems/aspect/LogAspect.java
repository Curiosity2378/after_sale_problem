package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.aspect;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.annotation.Log;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {
    @Resource
    private LogService logService;
    /**
     * 日志切入点
     */
    @Pointcut("@annotation(com.server.digitalmanagementsystemforenterpriseaftersalesproblems.annotation.Log)")
    public void logPointCut(){}


    @AfterReturning(pointcut = "logPointCut()")
    public void doAfter(JoinPoint joinPoint){
        //解析Log注解
        String methodName = joinPoint.getSignature().getName();
        Method method = currentMethod(joinPoint,methodName);
        Log log = method.getAnnotation(Log.class);
        String module = log.module();
        String description = log.description();
    }

    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 方法
     */
    private Method currentMethod(JoinPoint joinPoint, String methodName) {
        /**
         * 获取目标类的所有方法，找到当前要执行的方法
         */
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }

}
