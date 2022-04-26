package at2.ivanov.nikita.aop.aspect;

import at2.ivanov.nikita.aop.controller.MainController;
import at2.ivanov.nikita.aop.exception.MaxMethodCallsException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Map;

@Aspect
@Component
@Scope(value = "request")
@Slf4j
public class RequestCountAspect {
    @Value("${method.calls}")
    private Integer maxMethodCalls;
    // попробовал сделать рефлексией, все сломается если название поменять у метода
    // луше реализация на мапе, но хотелось попробовать рефлексию
    @Before("@annotation(requestCount)")
    public void counter(JoinPoint point, RequestCount requestCount)
            throws IllegalAccessException, NoSuchFieldException {
        Object handler = Proxy.getInvocationHandler(requestCount);
        Field f = handler.getClass().getDeclaredField("memberValues");
        f.setAccessible(true);
        Map<String, Object> memberValues = (Map<String, Object>) f.get(handler);
        int oldValue = (int) memberValues.get("initialCount");
        if (maxMethodCalls <= requestCount.initialCount())
            throw new MaxMethodCallsException("Method " + point.getSignature().getName() +
                    " calls " + oldValue + " times");
        memberValues.put("initialCount", oldValue + 1);
    }
}
