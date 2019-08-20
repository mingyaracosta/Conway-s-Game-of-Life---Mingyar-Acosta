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

    @Test
    public void testSettingHeightOfUniverse() {
        Universe universe = new Universe(9, 6);
        Assert.assertEquals(6, universe.getHeight());
    }

    @Test
    public void testSettingWidthOfUniverse() {
        Universe universe = new Universe(9, 6);
        Assert.assertEquals(9, universe.getWidth());
    }

    @Test
    public void testSettingAnAliveCell() {
        Universe universe = new Universe();
        universe.setCell(5, 5, new Cell());
        Assert.assertEquals(new Cell(), universe.getCell(5, 5));
    }

}
