package org.cleanarchitecture.msingi.patterns.specification;

public class OrSpecification<E> extends CompositeSpecification<E> {
    private Specification<E> left;
    private Specification<E> right;


    OrSpecification(Specification<E> left, Specification<E> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(E evaluated) {
        return left.isSatisfiedBy(evaluated) || right.isSatisfiedBy(evaluated);
    }
}
