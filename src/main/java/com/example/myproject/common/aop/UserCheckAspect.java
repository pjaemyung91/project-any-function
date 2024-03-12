package com.example.myproject.common.aop;

import com.example.myproject.common.annotation.LoginId;
import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import javax.security.auth.login.Configuration.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class UserCheckAspect {

//    @Around("@annotation(com.example.myproject.common.annotation.LoginId)")
    @Around("execution(* com.example.myproject.*.controller.*.*(..))")
//    @Around("@annotation(LoginId)")
    public Object proceed(ProceedingJoinPoint joinPoint) {

        try {
            Object[] args = joinPoint.getArgs();
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Parameter[] parameters = signature.getMethod().getParameters();

            for(int i = 0; i < parameters.length; i++) {
                if(parameters[i].isAnnotationPresent(LoginId.class)) {
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    args[i] = authentication.getPrincipal();
                }
            }

            return joinPoint.proceed(args);

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
