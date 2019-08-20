package com.mingyaracosta;

import org.junit.Assert;
import org.junit.Test;

public class UniverseTest {

    @Test
    public void testCreateUniverse() {
        Universe universe = new Universe();
        Assert.assertNotNull(universe);
    }

    @Test
    public void testGetDefaultHeightOfUniverse() {
        Universe universe = new Universe();
        Assert.assertEquals(10, universe.getHeight());
    }

    @Test
    public void testGetDefaultWidthOfUniverse() {
        Universe universe = new Universe();
        Assert.assertEquals(10, universe.getWidth());
    }
}
