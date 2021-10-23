package com.example.library2.orielly;

import static com.example.library2.orielly.LessThanOrEqual.lessThanOrEqual;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AssertTest {
    @Test
    public void assertEqualsTest() {
        Integer i = new Integer("5");
        Integer j = new Integer("5");
        assertEquals(i, j);
    }

    @Test
    public void assertSameTest() {
        Integer i = new Integer("5");
        Integer j = new Integer("5");
        assertSame(i, j);
    }

    @Test
    public void assertStringEqualsTest() {
        String i = new String("5");
        String j = new String("5");
        assertEquals(i, j);
    }

    @Test
    public void assertStringSameTest() {
        String i = new String("5");
        String j = new String("5");
        assertSame(i, j);
    }

    @Test
    public void assertThatTest() {
        int age = 30;
        assertThat(age, equalTo(30));
        assertThat(age, is(30));

        assertThat(age, not(equalTo(33)));
        assertThat(age, is(not(33)));
    }

    @Test
    public void verify_multiple_values() throws Exception {

        double marks = 100.00;
        assertThat(marks, either(is(100.00)).or(is(90.9)));

        assertThat(marks, both(not(99.99)).and(not(60.00)));

        assertThat(marks, anyOf(is(100.00), is(1.00), is(55.00), is(88.00), is(67.8)));

        assertThat(marks, not(anyOf(is(0.00), is(200.00))));

        assertThat(marks, not(allOf(is(1.00), is(100.00), is(30.00))));
    }


    @Test
    public void lessthanOrEquals_custom_matcher() throws Exception {
        int actualGoalScored = 2;
        assertThat(actualGoalScored, lessThanOrEqual(4));
        assertThat(actualGoalScored, lessThanOrEqual(2));

        double originalPI = 3.14;
        assertThat(originalPI, lessThanOrEqual(9.00));

        String authorName = "Sujoy";
        assertThat(authorName, lessThanOrEqual("Zachary"));
    }

    @Test
//    @Ignore
    public void lessthanOrEquals_failure() throws Exception {
        int maxInt = Integer.MAX_VALUE;
        assertThat(maxInt, lessThanOrEqual(Integer.MIN_VALUE));
    }
}
