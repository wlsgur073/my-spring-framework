package org.example.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationHandler {
    private final Class<?> clazz;
    private final Method targetMethod;

    public AnnotationHandler(Class<?> clazz, Method targetMethod) {
        this.clazz = clazz;
        this.targetMethod = targetMethod;
    }

    public String handle(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object handler = declaredConstructor.newInstance();

        return (String) targetMethod.invoke(handler, req, resp);
    };
}
