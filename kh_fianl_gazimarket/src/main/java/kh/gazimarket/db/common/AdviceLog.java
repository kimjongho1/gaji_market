package kh.gazimarket.db.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceLog {
	private static final Logger logger= LoggerFactory.getLogger(AdviceLog.class);
	
	@Pointcut("execution(public * kh.lclass.db1..*Dao.*(..))")
	public void daoPointCut() {}
	@Pointcut("execution(public * kh.lclass.db1..*Service.*(..))")
	public void servicePointCut() {}
	@Pointcut("execution(public * kh.lclass.db1..*Controller.*(..))")
	public void controllerPointCut() {}
	
//	@Before("daoPointCut()")
//	public void beforeDaoLog(JoinPoint jp) {
//		//공통코드
//		logger.debug("["+jp.getThis()+":"+jp.getSignature()+"]");
//		//타겟메소드로 전달되는 매개인자들
//		Object[] args = jp.getArgs();
//		for(int i=0; i<args.length;i++) {
//			logger.debug("--args["+i+"]"+args[i]);
//		}
//	}
	
	@Around("daoPointCut()")
	public Object afterDaoLog(ProceedingJoinPoint pjp) throws Throwable {
		Object robj = null; //타겟메세지로 부터 return 값을 받아 저장할 공간.
		//공통코드
		logger.debug("["+pjp.getThis()+": "+pjp.getSignature()+"]");
		
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]);
		}
		
		robj=pjp.proceed();
		logger.debug("[ Dao ]" + robj);
		return robj; //타겟메소드를 호출한 메소드에 return함.
	}
	
	@Around("servicePointCut()")
	public Object aroundSrvLog(ProceedingJoinPoint pjp) throws Throwable {
		Object robj = null; //타겟메세지로 부터 return 값을 받아 저장할 공간.
		//공통코드
		logger.debug("["+pjp.getThis()+":"+pjp.getSignature()+"]");
		
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]);
		}
		
		robj=pjp.proceed();
		logger.debug("[ Service ]" + robj);
		return robj; //타겟메소드를 호출한 메소드에 return함.
	}
	
	
	
	@Around("controllerPointCut()")
	public Object aroundCtrLog(ProceedingJoinPoint pjp) throws Throwable {
		Object robj = null; //타겟메세지로 부터 return 값을 받아 저장할 공간.
		//공통코드
		logger.debug("["+pjp.getThis()+":"+pjp.getSignature()+"]");
		
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length;i++) {
			logger.debug("--args["+i+"]"+args[i]);
		}

		robj=pjp.proceed();
		logger.debug("[ Ctrl ]" + robj);
		return robj; //타겟메소드를 호출한 메소드에 return함.
	}
}
