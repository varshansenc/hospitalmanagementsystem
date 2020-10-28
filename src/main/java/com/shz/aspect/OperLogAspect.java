package com.shz.aspect;

import com.shz.anno.Olog;
import com.shz.dao.IOperLogDao;
import com.shz.entity.OperLog;
import com.shz.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/19 20:56
 * @See com.shz.aspect
 */
@Aspect
@Component
public class OperLogAspect {

    @Autowired
    private IOperLogDao operLogDao;

    @Around("execution(* com.shz.controller.*.*(..)) && @annotation(com.shz.anno.Olog)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取userId
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        // 获取全类名
        String className = joinPoint.getTarget().getClass().getName();

        // 获取方法名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        // 获取注解
        Method method = methodSignature.getMethod();
        Olog olog = method.getAnnotation(Olog.class);

        // 获取注解属性值
        String operModule = olog.operModule();
        String operType = olog.operType();
        String operDesc = olog.operDesc();

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;

        // 添加日志
        operLogDao.insert(new OperLog(null, className, methodName, userId, time, new Date(), operModule, operType, operDesc));

        return result;
    }
}
