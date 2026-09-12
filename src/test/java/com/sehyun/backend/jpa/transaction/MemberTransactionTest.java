package com.sehyun.backend.jpa.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class MemberTransactionTest {

    @Autowired
    JpaMemberService memberService;

    @Test
    void rollbackTest() {
        assertThatThrownBy(() -> memberService.changeNameAndFail(1L))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("rollback test");
    }
}