package com.tradevan.switchgamestore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        String actual = "123";
        List<String> expected = new ArrayList<>();

        assertThat(expected).hasSize(0);

        assertThat(actual).hasToString("123");
    }

}
