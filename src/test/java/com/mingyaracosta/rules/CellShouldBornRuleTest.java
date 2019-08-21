package com.mingyaracosta.rules;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;
import org.junit.Assert;
import org.junit.Test;

public class CellShouldBornRuleTest {
    @Test
    public void testCellShouldBorn() {
        Cell cell = new Cell(State.DEAD);
        IRule rule = new CellShouldBornRule();
        Cell possibleNewAliveCell = rule.evaluate(cell, 3);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.ALIVE, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldntBornWith2Neighbors() {
        Cell cell = new Cell(State.DEAD);
        IRule rule = new CellShouldBornRule();
        Cell possibleNewCell = rule.evaluate(cell, 2);
        Assert.assertNull(possibleNewCell);
    }

    @Test
    public void testCellShouldntBornWith6Neighbors() {
        Cell cell = new Cell(State.DEAD);
        IRule rule = new CellShouldBornRule();
        Cell possibleNewCell = rule.evaluate(cell, 6);
        Assert.assertNull(possibleNewCell);
    }

    @Test
    public void testCellShouldntBornBecauseItsAlreadyAlive() {
        Cell cell = new Cell(State.ALIVE);
        IRule rule = new CellShouldBornRule();
        Cell possibleNewCell = rule.evaluate(cell, 3);
        Assert.assertNull(possibleNewCell);
    }
}
