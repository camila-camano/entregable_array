package com.example.arrayproducts.intercetor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfter {

    Logger logger = LogManager.getLogger(AspectAfter.class);

    // @Pointcut("execution(* com.coderhouse.controller.MessageController.getMensajeById(..))")
    //void alTerminarBusquedas() {}

    //  @Pointcut("execution(* com.coderhouse.controller.*.*(..))")
    // void alTerminarBusquedasAll() {}
//
//    @After("alTerminarBusquedasAll()")
//    void afterAdviceMethodAll() {
//        logger.info("Se ejecutó el after advice luego de la ejecución de cualquier método del paquete controller");
//    }
//
    //  @After("alTerminarBusquedas()")
    // void aftereAdviceMethod() {
    //     logger.info("Se ejecutó el after advice luego de la ejecución del método con o sin excepcion");
    //  }
//
    // @AfterReturning("alTerminarBusquedas()")
    // void afterRetuningAdviceMethod() {
    //      logger.info("Se ejecuto el after advice cuando no hay una excepción en la ejecución del método getMensajeById de la capa Controller");
    // }
//
//    @AfterThrowing("execution(* com.coderhouse.controller.*.*(..))")
//    void afterThrowingAdviceMethod() {
//        logger.info("Se ejecuto el after advice cuando hay una excepción en la ejecución de un método de la capa Controller");
//    }
}
