package com.sehyun.backend.db.lock;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Account {

    private Long id;
    private long balance;
    private long version;
}