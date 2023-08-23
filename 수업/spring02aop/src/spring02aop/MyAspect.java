package spring02aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	@Around("execution(* factorial(..))")
	public Object printAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around전");
		long start = System.nanoTime();
		Object result = pjp.proceed(); // 타겟 메서드 실행, 결과 수신
		long end = System.nanoTime();
		System.out.println("걸린시간: " + (end - start) + "ns");
		System.out.println("around후");
		return result;
	}

//	@Before("execution(* factorial(..))")
//	public void printBefore2() {
//		System.out.println("계산 전");
//	}

	@Before("execution(* SimpleCalc.*(..))")
	public void printBefore() {
		System.out.println("계산 전");
	}
}
