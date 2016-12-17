package com.treegrowth.model.entity;


import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@DynamicUpdate
public abstract class Base implements Serializable {

    private static final long serialVersionUID = -5110102208966650556L;
    @NotNull
    @Id
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private String id = UUID.randomUUID().toString().replace("-", "");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, ImmutableList.of("id"));
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, ImmutableList.of("id"));
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == this) return true;
//        if (!(o instanceof Base)) return false;
//        Base base = (Base) o;
//        return Objects.equals(getId(), base.getId());
//    }
//
//    public int hashCode() {
//        return Objects.hash(getId());
//    }

}
