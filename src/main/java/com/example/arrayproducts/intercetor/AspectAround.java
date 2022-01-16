package com.example.arrayproducts.intercetor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAround {

    Logger logger = LogManager.getLogger(AspectAround.class);

    // @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")  //lo mismo q abajo
    // @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    //void controllerClassMethods() {}

    //@Around("controllerClassMethods()")
    // Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    //    long start = System.nanoTime();
    //    Object ret = joinPoint.proceed();
    //  long end = System.nanoTime();

    //   logger.info("Se ejecuto el metodo con una duración de {} ms", TimeUnit.NANOSECONDS.toMillis(end - start));
    //    return ret;
    // }

}
