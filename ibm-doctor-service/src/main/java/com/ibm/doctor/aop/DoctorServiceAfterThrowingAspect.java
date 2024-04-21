package com.ibm.doctor.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class DoctorServiceAfterThrowingAspect {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@AfterThrowing(pointcut = "execution(* com.ibm.doctor.service.DoctorService.*(..))")
	public void exceptionUserNotFound(JoinPoint obj) {
			LOG.warn("User Not Found : " + obj.getSignature().toString());
	}

}
