package org.cleanarchitecture.test.runners.junit;

import org.cleanarchitecture.test.runners.RSpecTestNameGenerator;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class JUnitWithSpecTestNameRunner extends BlockJUnit4ClassRunner {
    public JUnitWithSpecTestNameRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected String testName(FrameworkMethod method) {
        return RSpecTestNameGenerator.generateTestName(method.getMethod());
    }
}
