package org.cleanarchitecture.msingi.domain;

import javax.validation.ConstraintViolationException;

public interface Validatable {
    void validate() throws ConstraintViolationException;
}
