package com.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GfgTest {

    Gfg testObj = new Gfg();

    @Test
    public void testReduceFraction() {
        int result = testObj.reduceFraction(6,3);
        Assertions.assertEquals(3, result);
    }
}
