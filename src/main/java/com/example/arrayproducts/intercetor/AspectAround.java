package com.example.arrayproducts.intercetor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AspectAround {

    Logger logger = LogManager.getLogger(AspectAround.class);

    @Around("execution(* com.example.arrayproducts.controller.*.*(..)) && " +
            "!execution(* com.example.arrayproducts.controller.ProductoController.deleteProduct())")
    Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
       long start = System.nanoTime();
        Object ret = joinPoint.proceed();
      long end = System.nanoTime();

      logger.info("Ejecutando AROUND en un método que no es DELETE.");
       logger.info("Se ejecutó el método con una duración de {} ms.", TimeUnit.NANOSECONDS.toMillis(end - start));
       return ret;
     }

}
