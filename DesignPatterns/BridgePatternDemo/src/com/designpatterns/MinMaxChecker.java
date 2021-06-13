package com.designpatterns;

import java.util.function.Supplier;

class MinMaxChecker<T extends Number & Comparable<? super T>> {
    private final Supplier<T> zero;

    public MinMaxChecker(Supplier<T> zero) {
        this.zero = zero;
    }

    public T check(T val, T min, T max) {
        val = max(val, max);
        val = min(val, min);
        return val;
    }
    public T check(T val, T max){
        return check(val, zero.get(), max);
    }

    // ---
    private T max(T val, T itsMax) {
        return val.compareTo(itsMax) >= 0 ? itsMax : val;
    }

    private T min(T val, T itsMin) {
        return val.compareTo(itsMin) <= 0 ? itsMin : val;
    }
}

