package org.cleanarchitecture.common.patterns.specification;

public interface Specification<E> {
    /**
     * Is this specification satisfied by the evaluated object?
     */
    public boolean isSatisfiedBy(E evaluated);

    public Specification<E> and(Specification<E> otherSpec);

    public Specification<E> or(Specification<E> otherSpec);
}
