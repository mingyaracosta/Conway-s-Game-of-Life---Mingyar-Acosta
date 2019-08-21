package com.mingyaracosta;

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

    @Test
    public void testCellShouldBorn() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = gameEngine.getCellForNextGeneration(cell, 3);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.ALIVE, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldntBornWith2Neighbors() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = gameEngine.getCellForNextGeneration(cell, 2);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldntBornWith6Neighbors() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = gameEngine.getCellForNextGeneration(cell, 6);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldKeepDeadWithNoNeighborsAlive() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = gameEngine.getCellForNextGeneration(cell, 0);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }

    @Test
    public void testCellShouldKeepDeadWith6NeighborsAlive() {
        cell = new Cell(State.DEAD);
        Cell possibleNewAliveCell = gameEngine.getCellForNextGeneration(cell, 0);
        Assert.assertNotNull(possibleNewAliveCell);
        Assert.assertEquals(State.DEAD, possibleNewAliveCell.getState());
    }
}
