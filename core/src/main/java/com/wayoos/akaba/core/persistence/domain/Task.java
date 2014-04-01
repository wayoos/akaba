package com.wayoos.akaba.core.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by steph on 01.04.14.
 */
@Entity
public class Task {

    private Long id;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
