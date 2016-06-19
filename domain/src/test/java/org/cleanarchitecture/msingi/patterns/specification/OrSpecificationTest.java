package org.cleanarchitecture.msingi.patterns.specification;

;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;


public class OrSpecificationTest {
    private OrSpecification spec;
    @Mock private Specification alwaysTrue, alwaysFalse;
    private Object evaluated;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(alwaysTrue.isSatisfiedBy(anyObject())).thenReturn(true);
        when(alwaysFalse.isSatisfiedBy(anyObject())).thenReturn(false);

        evaluated = new Object();
    }

    @Test
    public void returnsTrueIfOneOfProvidedSpecsIsTrue() {
        spec = new OrSpecification(alwaysTrue, alwaysFalse);
        assertTrue(spec.isSatisfiedBy(evaluated));

        spec = new OrSpecification(alwaysFalse, alwaysTrue);
        assertTrue(spec.isSatisfiedBy(evaluated));
    }

    @Test
    public void returnsFalseIfBothSpecsAreFalse() {
        spec = new OrSpecification(alwaysFalse, alwaysFalse);
        assertFalse(spec.isSatisfiedBy(evaluated));
    }
}
