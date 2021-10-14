package com.example.daggerexample.scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Scope;

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface DieselV2Scope {
}
