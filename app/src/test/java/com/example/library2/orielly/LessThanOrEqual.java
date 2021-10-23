package com.example.library2.orielly;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class LessThanOrEqual<T extends Comparable<T>> extends BaseMatcher<Comparable<T>> {
    private final Comparable<T> expectedValue;

    public LessThanOrEqual(T expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Factory
    public static <T extends Comparable<T>> Matcher<T> lessThanOrEqual(T t) {
        return new LessThanOrEqual(t);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" less than or equal(<=) " + expectedValue);
    }


    @Override
    public boolean matches(Object t) {
        int compareTo = expectedValue.compareTo((T) t);
        return compareTo > -1;
    }
}
