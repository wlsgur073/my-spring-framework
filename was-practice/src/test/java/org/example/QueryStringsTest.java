package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @Test
    void createText() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&perator=*&operand2=55"); // List<QueryString>

        assertThat(queryStrings).isNotNull();
    }
}
