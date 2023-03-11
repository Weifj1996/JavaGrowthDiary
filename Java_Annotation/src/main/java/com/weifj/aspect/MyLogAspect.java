package com.weifj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  //1. 表示这是一个切面类
@Component
public class MyLogAspect {

    // 2. pointCut 表示这是一个切点 @annotation表示这个切点切刀一个注解上，后面带该注解的全类名
    // 切面最主要的就是切点，所有都是围绕切点发生
    // logPointCut() 代表切点的名称
    @Pointcut("@annotation(com.weifj.annotation.MyLog)")
    public void logPointCut() {
    }

    // 3.环绕通知
    @Around("logPointCut()")
    public void logAround(ProceedingJoinPoint joinPoint) {
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取入参
        Object[] args = joinPoint.getArgs();

        StringBuilder stringBuilder = new StringBuilder();
        for (Object arg : args) {
            stringBuilder.append(arg + ";");
        }

        System.out.println("进入[" + methodName + "]方法,参数为:" + stringBuilder.toString());

        // 继续执行方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(methodName + " 方法执行结束");
    }


}
