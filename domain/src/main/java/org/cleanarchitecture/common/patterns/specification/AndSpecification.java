package org.cleanarchitecture.common.patterns.specification;


class AndSpecification<E> extends CompositeSpecification<E> {
    private Specification<E> left;
    private Specification<E> right;

    AndSpecification(Specification<E> left, Specification<E> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(E evaluated) {
        return left.isSatisfiedBy(evaluated) && right.isSatisfiedBy(evaluated);
    }
}
