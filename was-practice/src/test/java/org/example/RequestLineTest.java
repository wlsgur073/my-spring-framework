package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {

    @Test
    void create() {
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&perator=*&operand2=55 HTTP/1.1");

        assertThat(requestLine).isNotNull();

        // 객체과 객체를 비교할때는 equals() hashCode()가 필요하다.
        assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=11&perator=*&operand2=55"));

    }
}
