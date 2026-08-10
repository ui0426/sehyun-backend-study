package com.sehyun.backend.java.objectmethod;

import java.util.Objects;

public class MemberV2 {
    private final Long id;
    private final String name;

    public MemberV2(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MemberV2)) {
            return false;
        }

        MemberV2 member = (MemberV2) o;

        return Objects.equals(id, member.id)
                && Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
