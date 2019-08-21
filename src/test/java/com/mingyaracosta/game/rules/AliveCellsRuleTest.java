package com.mingyaracosta.game.rules;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AliveCellsRuleTest {
    private static IRule rule;
    private static Cell cell;

    @BeforeClass
    public static void setUp() {
        rule = new AliveCellsRule();
    }

    @Test
    public void testShouldKeepAliveWith2AliveNeighbors() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = rule.evaluate(cell, 2);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.ALIVE, possibleDeadCell.getState());
    }

    @Test
    public void testShouldKeepAliveWith3AliveNeighbors() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = rule.evaluate(cell, 2);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.ALIVE, possibleDeadCell.getState());
    }

    @Test
    public void testShouldntBeAliveOrDeadBecauseItsDead() {
        cell = new Cell(State.DEAD);
        Cell possibleDeadCell = rule.evaluate(cell, 2);
        Assert.assertNull(possibleDeadCell);
    }

    @Test
    public void testItShouldDieBecausOfLonelinessWith1AliveNeighbor() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = rule.evaluate(cell, 1);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.DEAD, possibleDeadCell.getState());
    }

    @Test
    public void testItShouldDieBecausOfLonelinessWithNoAliveNeighbor() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = rule.evaluate(cell, 0);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.DEAD, possibleDeadCell.getState());
    }

    @Test
    public void testItShouldDieBecausOfOverpopulationWith5AliveNeighbor() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = rule.evaluate(cell, 5);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.DEAD, possibleDeadCell.getState());
    }
}