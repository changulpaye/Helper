package com.parm.helper.dependencies.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Custom scope for Dependency Injection.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
