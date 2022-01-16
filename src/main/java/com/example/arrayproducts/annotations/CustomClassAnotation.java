package com.example.arrayproducts.annotations;


import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomClassAnotation {
}
