package org.cleanarchitecture.msingi.patterns.specification;

public abstract class CompositeSpecification<E> implements Specification<E> {
    @Override
    public Specification<E> and(Specification<E> other) {
        return new AndSpecification<E>(this, other);
    }

    @Override
    public Specification<E> or(Specification<E> other) {
        return new OrSpecification<E>(this, other);
    }
}
