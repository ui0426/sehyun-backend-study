package com.sehyun.backend.db.index;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Member {

    private Long id;
    private String name;
    private Integer age;
    private String status;
    private LocalDateTime createdAt;
}