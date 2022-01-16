package com.example.arrayproducts.intercetor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectBefore {

   // Logger logger = LogManager.getLogger(AspectBeforeExample.class);
/*
    @Pointcut("execution(* com.coderhouse.controller.MessageController.getMensajeById(..))")
    void paraBusquedasById() {}

    @Pointcut("execution(* com.coderhouse.controller.*.*(..))")
    void paraBusquedasAll() {}
*/

    //@Before("paraBusquedasById()")
    // void beforeAdviceMethod1() {
    //      //mostra en log
    //      logger.info("Se ejecutó el before advice antes " +
    //             "de la ejecución del método getMensajeById() 01");
    // }
//
//    @Before("paraBusquedasById()")
//    void beforeAdviceMethod2() {
//        //insertar en una tabla de una bd
//        logger.info("Se ejecutó el before advice antes " +
//                "de la ejecución del método getMensajeById() 02");
//    }
//
//    @Before("paraBusquedasById()")
//    void beforeAdviceMethod3() {
//        // insetar en caché
//        logger.info("Se ejecutó el before advice antes " +
//                "de la ejecución del método getMensajeById() 03");
//    }
//
//    @Before("paraBusquedasAll()")
//    void beforeAdviceMethodAll() {
//        logger.info("Se ejecutó el before advice antes de la ejecución " +
//                "de cualquier método del paquete controller");
//    }
//
    //@Before("execution(* com.coderhouse.controller.*.*(..)) && " +
     //       "!execution(* com.coderhouse.controller.MessageController.getMensajeById(..))")
    //void beforeAdviceAllPackageMethod() {
    //    logger.info("Se ejecutó el before advice antes de la ejecución de cualquier método del paquete excepto el método getMensajeById");
    //}

    // @Before("paraBusquedasById()")
    // void beforeAdviceJoinpointMethod(JoinPoint joinPoint) {
    //  String methodName = joinPoint.getSignature().getName();
    //  String target = joinPoint.getTarget().getClass().getSimpleName();
    //  String type = joinPoint.getKind();

    //  logger.info("Se ejecutó el before advice antes de la ejecución del método");
    //    logger.info("Method: {}", methodName);
    //  logger.info("Target: {}", target);
    //   logger.info("Type: {}", type);
    // }
//
//    @Before("@annotation(com.coderhouse.annotations.CustomMethodAnnotation)")
//    void beforeAdviceAnnotationMethods(JoinPoint joinPoint) {
//        logger.info("Se inpecciona el método {} usando una anotación personalizada", joinPoint.getSignature().getName());
//    }

}