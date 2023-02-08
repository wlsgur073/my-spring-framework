package org.example;

import org.example.anootation.Controller;
import org.example.anootation.Service;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

// @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.
public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

        logger.debug("beans : [{}]", beans);
    }

    @Test
    void showClass() { // 클래스에 대한 모든 정보를 출력하는 메서드
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());

        logger.debug("User all declared fields : [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors : [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared method : [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {
        // 힙 영역에 로드돼 있는 클래스 타입의 객체를 가지고 오는 세 가지 방법

        // 1
        Class<User> clazz1 = User.class;

        // 2
        User user = new User("serverwizard", "홍길동");
        Class<? extends User> clazz2 = user.getClass();

        // 3
        Class<?> clazz3 = Class.forName("org.example.model.User");

        logger.debug("clazz1: [{}]", clazz1);
        logger.debug("clazz2: [{}]", clazz2);
        logger.debug("clazz3: [{}]", clazz3);

        assertThat(clazz1 == clazz2).isTrue();
        assertThat(clazz3 == clazz2).isTrue();
        assertThat(clazz3 == clazz1).isTrue();
    }

    private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        // org.example 패키지 밑에 있는 모든 클래스 대상으로 Reflect 사용
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
//      Controller라는 애노테이션이 붙어져 있는 대상들을 다 찾아서 해당 HashSet에 초기화해줌
//        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));
//        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));

        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }
}
