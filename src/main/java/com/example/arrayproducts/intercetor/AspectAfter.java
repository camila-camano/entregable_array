package com.example.arrayproducts.intercetor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfter {

    Logger logger = LogManager.getLogger(AspectAfter.class);


    @After("@annotation(com.example.arrayproducts.annotations.CustomMethodAnotation)")
     void afterAdviceMethod() {
         logger.info("Se ejecutó el AFTER advice luego de la ejecución de un PUT/DELETE.");
     }

    @AfterThrowing("execution(* com.example.arrayproducts.controller.ProductoController.updateProduct(..))")
    void afterThrowingAdviceMethod() {
        logger.info("Se ejecutó el AFTER advice luego de capturar una excepción de PUT con nombre vacio.");
    }


}
