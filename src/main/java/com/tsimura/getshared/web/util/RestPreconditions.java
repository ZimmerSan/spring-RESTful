package com.tsimura.getshared.web.util;

import com.tsimura.getshared.web.exception.MyResourceNotFoundException;
import org.springframework.http.HttpStatus;

/**
 * Simple static methods to be called at the start of methods
 * to verify correct arguments and state.
 * If the Precondition fails, an {@link HttpStatus} code is thrown
 */
public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param expression
     *            has value true if found, otherwise false
     * @throws MyResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression) {
        if (!expression) throw new MyResourceNotFoundException();
    }

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param resource
     *            Object to find
     * @throws MyResourceNotFoundException
     *             if object is null, means object not found.
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) throw new MyResourceNotFoundException();
        return resource;
    }

}