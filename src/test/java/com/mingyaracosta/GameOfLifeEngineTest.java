package com.mingyaracosta;

import com.mingyaracosta.rules.AliveCellsRule;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameOfLifeEngineTest {
    private static Cell cell;
    private static GameOfLifeEngine gameEngine;

    @BeforeClass
    public static void setUp() {
        gameEngine = new GameOfLifeEngine();
    }

    @Test
    public void testShouldKeepAliveWith2AliveNeighbors() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = gameEngine.getCellForNextGeneration(cell, 2);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.ALIVE, possibleDeadCell.getState());
    }

    @Test
    public void testShouldKeepAliveWith3AliveNeighbors() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = gameEngine.getCellForNextGeneration(cell, 2);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.ALIVE, possibleDeadCell.getState());
    }

    @Test
    public void testItShouldDieBecausOfLonelinessWith1AliveNeighbor() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = gameEngine.getCellForNextGeneration(cell, 1);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.DEAD, possibleDeadCell.getState());
    }

    @Test
    public void testItShouldDieBecausOfLonelinessWithNoAliveNeighbor() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = gameEngine.getCellForNextGeneration(cell, 0);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.DEAD, possibleDeadCell.getState());
    }

    @Test
    public void testItShouldDieBecausOfOverpopulationWith5AliveNeighbor() {
        cell = new Cell(State.ALIVE);
        Cell possibleDeadCell = gameEngine.getCellForNextGeneration(cell, 5);
        Assert.assertNotNull(possibleDeadCell);
        Assert.assertEquals(State.DEAD, possibleDeadCell.getState());
    }
}
