package com.spring.demo.handlers;

public interface EventHandlerChecker<T> {
    boolean isValid(T event);
}
