package io.hrnugr.entity;

import org.springframework.data.redis.core.index.Indexed;

public class Address {

    @Indexed
    private Long id;

    public Address(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
