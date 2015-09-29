package org.cleanarchitecture.test.runners.powermock;

import org.cleanarchitecture.test.runners.RSpecTestNameGenerator;
import org.junit.internal.runners.InitializationError;
import org.powermock.core.spi.PowerMockTestListener;
import org.powermock.modules.junit4.internal.impl.PowerMockJUnit44RunnerDelegateImpl;

import java.lang.reflect.Method;


public class DisplayTestNameAsSpecClassRunner extends PowerMockJUnit44RunnerDelegateImpl {

    public DisplayTestNameAsSpecClassRunner(Class<?> klass, String[] methodsToRun, PowerMockTestListener[] listeners) throws InitializationError {
        super(klass, methodsToRun, listeners);
    }

    public DisplayTestNameAsSpecClassRunner(Class<?> klass, String[] methodsToRun) throws InitializationError {
        super(klass, methodsToRun);
    }

    public DisplayTestNameAsSpecClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected String testName(Method method) {
        return RSpecTestNameGenerator.generateTestName(method);
    }
}
