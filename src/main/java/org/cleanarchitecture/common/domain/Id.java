package org.cleanarchitecture.common.domain;


public interface Id<E extends Entity<E>> {
    String getValue();
    Class<E> entityType();
}
