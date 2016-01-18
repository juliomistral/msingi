package org.cleanarchitecture.common.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Set;

public abstract class Entity<E extends Entity<E>> implements Validatable {
    private Id<E> id;
    @Min(0) private int version;
    private Date created;
    private Date updated;
    protected Validator validator;


    protected Entity() {
        this.version = 0;
        this.created = new Date();
        this.updated = new Date();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public Id<E> getId() { return id; }
    public int getVersion() { return version; }
    public Date getCreated() { return created; }
    public Date getUpdated() { return updated; }

    public E withId(final Id<E> uid) {
        this.id = uid;
        return (E) this;
    }

    public E witCreated(final Date created) {
        this.created = created;
        return (E) this;
    }

    public E withUpdated(final Date updated) {
        this.updated = updated;
        return (E) this;
    }

    public E withVersion(final int version) {
        this.version = version;
        return (E) this;
    }

    @Override
    public void validate() throws ConstraintViolationException {
        Set<ConstraintViolation<Entity<E>>> violations = this.validator.validate(this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("version", version)
                .append("updated", updated)
                .append("created", created)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity<?> entity = (Entity<?>) o;
        return !(getId() != null ? !getId().equals(entity.getId()) : entity.getId() != null);
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
