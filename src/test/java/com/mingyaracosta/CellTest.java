package com.mingyaracosta;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

    @Test
    public void testIfCellIsAlive() {
        Cell cell = new Cell();
        Assert.assertEquals(State.ALIVE, cell.getState());
    }

    @Test
    public void testIfCellIsDead() {
        Cell cell = new Cell();
        cell.setState(State.DEAD);
        Assert.assertEquals(State.DEAD, cell.getState());
    }
}
