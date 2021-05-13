package com.example.demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLogger {

    private static int count = 0;

    @Before("execution(* com.example.demo.controller.BookController.create*(..))")
    public void messCreate() {
        System.out.println("truoc khi tao moi sach");
    }
    @Before("execution(* com.example.demo.controller.BookController.thueSach*(..))")
    public void messThueSach() {
        System.out.println("truoc khi thue sach");
    }

    @Before("execution(* com.example.demo.controller.BookController.traSach*(..))")
    public void messTraSach() {
        System.out.println("truoc khi tra sach");
    }


    @Before("execution(* com.example.demo.controller.BookController.*(..))")
    public void messCount() {
        count++;
        System.out.println("so nguoi truy cap: "+count);
    }
}
