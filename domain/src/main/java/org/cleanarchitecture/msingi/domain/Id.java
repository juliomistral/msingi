package org.cleanarchitecture.msingi.domain;


public interface Id<E extends Entity<E>> {
    String getValue();
    Class<E> entityType();
}
