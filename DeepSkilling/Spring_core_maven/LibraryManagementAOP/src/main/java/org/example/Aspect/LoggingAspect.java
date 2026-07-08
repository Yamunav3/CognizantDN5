package org.example.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
    public  void beforeMethod() {
        System.out.println("Method started..");
    }
    public void afterMethod() {
        System.out.println("Method Completed");
    }
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        long start=System.currentTimeMillis();
        Object object=joinPoint.proceed();
        long end=System.currentTimeMillis();
        System.out.println("Execution time "+(end-start)+"ms");
        return object;
    }

}
