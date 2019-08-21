package com.mingyaracosta.game;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;
import com.mingyaracosta.Universe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameOfLifeEngineTest {
    private static Cell cell;
    private static Universe universe;
    private static GameOfLifeEngine gameEngine;

    @Before
    public void setUp() {
        universe = new Universe(3, 3);
        universe.initializeCells(State.ALIVE);
        gameEngine = new GameOfLifeEngine(universe);
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



    /**
     * * 1 1
     * 1 1 1
     * 1 1 1
     */
    @Test
    public void testCount3AliveNeighborsTopLeftCornerCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(0, 0);
        Assert.assertEquals(3, aliveNeighborsCount);
    }

    /**
     * 1 * 1
     * 1 1 1
     * 1 1 1
     */
    @Test
    public void testCount3AliveNeighborsTopCenterCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(1, 0);
        Assert.assertEquals(5, aliveNeighborsCount);
    }

    /**
     * 1 1 *
     * 1 1 1
     * 1 1 1
     */
    @Test
    public void testCount3AliveNeighborsTopRightCornerCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(2, 0);
        Assert.assertEquals(3, aliveNeighborsCount);
    }

    /**
     * 1 1 1
     * * 1 1
     * 1 1 1
     */
    @Test
    public void testCount3AliveNeighborsMiddleLeftCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(0, 1);
        Assert.assertEquals(5, aliveNeighborsCount);
    }

    /**
     * 1 1 1
     * 1 * 1
     * 1 1 1
     */
    @Test
    public void testCount8AliveNeighborsCenterCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(1, 1);
        Assert.assertEquals(8, aliveNeighborsCount);
    }

    /**
     * 1 1 1
     * 1 1 *
     * 1 1 1
     */
    @Test
    public void testCount3AliveNeighborsMiddleRightell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(2, 1);
        Assert.assertEquals(5, aliveNeighborsCount);
    }

    /**
     * 1 1 1
     * 1 1 1
     * * 1 1
     */
    @Test
    public void testCount3AliveNeighborsBottomLeftCornerCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(0, 2);
        Assert.assertEquals(3, aliveNeighborsCount);
    }

    /**
     * 1 1 1
     * 1 1 1
     * 1 * 1
     */
    @Test
    public void testCount3AliveNeighborsBottomCenterCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(1, 2);
        Assert.assertEquals(5, aliveNeighborsCount);
    }

    /**
     * 1 1 1
     * 1 1 1
     * 1 1 *
     */
    @Test
    public void testCount3AliveNeighborsTopBottomCornerCell() {
        int aliveNeighborsCount = gameEngine.countAliveNeighbors(2, 2);
        Assert.assertEquals(3, aliveNeighborsCount);
    }
}
