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

    @Test
    public void testSettingADeadCell() {
        Universe universe = new Universe();
        universe.setCell(5, 5, new Cell(State.DEAD));
        Assert.assertNotEquals(new Cell(), universe.getCell(5, 5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBoundsExceptionOnSetCell() {
        Universe universe = new Universe();
        universe.setCell(5, 50, new Cell(State.DEAD));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBoundsExceptionOnGetCell() {
        Universe universe = new Universe();
        Cell notRetrievableCell = universe.getCell(5, 50);
        Assert.assertEquals(new Cell(), notRetrievableCell);
    }

    @Test
    public void testInitializeAllUniverseWithAliveCells() {
        Universe universe = new Universe();
        universe.initializeCells(State.ALIVE);
        Cell actualCell = universe.getCell(0, 0);
        Assert.assertEquals(new Cell(), actualCell);
    }

    @Test
    public void testInitializeAllUniverseWithDeadCells() {
        Universe universe = new Universe();
        universe.initializeCells(State.DEAD);
        Cell actualCell = universe.getCell(0, 0);
        Assert.assertEquals(new Cell(State.DEAD), actualCell);
    }

    @Test
    public void testCountCellsAliveBaseCase() {
        Universe universe = new Universe(5, 5);
        universe.initializeCells(State.DEAD);
        int aliveCellsCount = universe.getCellsAliveCount();
        Assert.assertEquals(0, aliveCellsCount);
    }

    @Test
    public void testCountCellsAliveRegularCase() {
        Universe universe = new Universe(5, 5);
        universe.initializeCells(State.DEAD);
        universe.setCell(1, 1, new Cell());
        universe.setCell(2, 2, new Cell());
        int aliveCellsCount = universe.getCellsAliveCount();
        Assert.assertEquals(2, aliveCellsCount);
    }
}
