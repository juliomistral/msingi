package org.cleanarchitecture.common.patterns.specification;

import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

public class AndSpecificationTest {
    private  AndSpecification spec;
    @Mock private Specification alwaysTrue, alsoAlwaysTrue, alwaysFalse;
    private Object evaluated;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(alwaysTrue.isSatisfiedBy(anyObject())).thenReturn(true);
        when(alsoAlwaysTrue.isSatisfiedBy(anyObject())).thenReturn(true);
        when(alwaysFalse.isSatisfiedBy(anyObject())).thenReturn(false);

        evaluated = new Object();
    }

    @Test
    public void returnsTrueIfBothOfTheProvidedSpecsAreTrue() {
        spec = new AndSpecification(alwaysTrue, alsoAlwaysTrue);
        assertThat(spec.isSatisfiedBy(evaluated)).as("Spec result").isTrue();
    }

    @Test
    public void returnsFalseIfEitherOfTheProvidedSpecsAreFalse() {
        spec = new AndSpecification(alwaysTrue, alwaysFalse);
        assertThat(spec.isSatisfiedBy(evaluated)).as("Spec result").isFalse();

        spec = new AndSpecification(alwaysFalse, alwaysTrue);
        assertThat(spec.isSatisfiedBy(evaluated)).as("Spec result").isFalse();
    }
}
