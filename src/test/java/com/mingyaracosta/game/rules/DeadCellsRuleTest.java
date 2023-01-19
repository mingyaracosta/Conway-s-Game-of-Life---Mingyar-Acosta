package com.mingyaracosta.game.rules;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeadCellsRuleTest {

    private static IRule rule;
    private static Cell cell;

    @BeforeClass
    public static void setUp() {
        rule = new DeadCellsRule();
    }
/*
    @Test
    public void testCellShouldBorn() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = rule.evaluate(cell, 3);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.ALIVE, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldntBornWith2Neighbors() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = rule.evaluate(cell, 2);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldntBornWith6Neighbors() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = rule.evaluate(cell, 6);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldntBornBecauseItsAlreadyAlive() {
        cell = new Cell(State.ALIVE);
        Cell possibleNewAliveCell = rule.evaluate(cell, 3);
        Assert.assertNull(possibleNewAliveCell);
    }

    @Test
    public void testCellShouldKeepDeadWithNoNeighborsAlive() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = rule.evaluate(cell, 0);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldKeepDeadWith6NeighborsAlive() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = rule.evaluate(cell, 0);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }*/
}
