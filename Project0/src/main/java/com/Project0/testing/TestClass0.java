package com.Project0.testing;

import com.enterprise.annotations.TestMethod;

public class TestClass0 {
    int i;

    public TestClass0(int j) {
        this.i = j;
    }

    @TestMethod(
            name = "constructor",
            expected = "blah"
    )
    public int blah() {
        return 0;
    }
}
