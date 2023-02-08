package org.example.anootation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE}) // 클래스에다 Controller라는 애노테이션을 붙이기 위해서 넣음
@Retention(RetentionPolicy.RUNTIME) // 유지기간은 Runtime 기간까지로 설정
public @interface Controller {
}
