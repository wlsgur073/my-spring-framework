package org.example.di;

import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;

public class BeanFactoryUtils {
    public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
        // clazz타입 객체의 모든 생성자를 가지고 온다.
        // 단, Inject 에노테이션이 붙은 객체의 생성자만 가져온다.
        Set<Constructor> injectedConstructors = ReflectionUtils.getAllConstructors(clazz, ReflectionUtils.withAnnotation(Inject.class));
        if (injectedConstructors.isEmpty()){
            return null;
        }
        return injectedConstructors.iterator().next();
    }
}
