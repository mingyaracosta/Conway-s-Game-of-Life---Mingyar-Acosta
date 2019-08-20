package com.mingyaracosta;

import org.junit.Assert;
import org.junit.Test;

public class UniverseTest {

    @Test
    public void testCreateUniverse() {
        Universe universe = new Universe();
        Assert.assertNotNull(universe);
    }
}
