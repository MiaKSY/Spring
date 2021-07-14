package aop3_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;






@Aspect
// 이 클래스가 메모리에 올라가게끔 스크링 콘테이너 가 알아서 올라가줄래?
// 이 클래스를 빈으로 생성하고 싶어
@Component
public class LoggingAdvice {
	
	public void before(JoinPoint point) throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[****before사전작업*****]" + methodName);
	}
	
	
	// around = before + after
	// 위에 @Aspect 만들고 여기서 @Around 해준 다음에, 적용할 것들 지정 
	@Order(value=1)
	@Around("execution(public *  aop3_annotation.*.Hello(..)")
	public Object around(ProceedingJoinPoint point)throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[=====around사전작업=====]" + methodName);
		Object obj = point.proceed();
		System.out.println("[.....around사후작업.....]" + methodName);
		return obj;
	}
}
