package org.example.anootation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // 해당 애노테이션은 클래스뿐만 아니라, 메서드에도 추가할 수 있게 설정
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";

//  GET, POST 요청에 따른 RequestMethod를 설정해준다.
    RequestMethod[] method() default {}; // 여러 개의 요청이 올 수 있어서 배열 선언
}
