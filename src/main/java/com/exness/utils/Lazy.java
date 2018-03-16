package com.exness.utils;

import java.util.Optional;
import java.util.function.Supplier;

public class Lazy<T> {

    private Optional<T> instance = Optional.empty();
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) {
        supplier = supplier;
    }

    public T get() {
        if(!instance.isPresent()) {
            instance = Optional.of(supplier.get());
        }

        return instance.get();
    }

}
