package org.cleanarchitecture.common.repo;

import org.cleanarchitecture.common.domain.Entity;
import org.cleanarchitecture.common.domain.Id;

public interface Repository<E extends Entity<E>> {
    E get(Id<E> id);
    Id<E> create(E entity);
}
