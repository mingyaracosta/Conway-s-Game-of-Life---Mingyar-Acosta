package com.mingyaracosta.game;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;
import com.mingyaracosta.Universe;
import com.mingyaracosta.game.rules.AliveCellsRule;
import com.mingyaracosta.game.rules.DeadCellsRule;
import com.mingyaracosta.game.rules.IRule;
import com.mingyaracosta.game.rules.IRuleImpl;

public class GameOfLifeEngine {

    private Universe universe;
    private IRuleImpl firstRule;

    public GameOfLifeEngine() {
        this.firstRule = new DeadCellsRule();
        IRule secondRule = new AliveCellsRule();
        this.firstRule.setNextRule(secondRule);
    }

    public GameOfLifeEngine(Universe universe) {
        this();
        this.universe = universe;
    }

    Cell getCellForNextGeneration(Cell currentCell, int aliveNeighborsCount) {
        return this.firstRule.evaluate(currentCell, aliveNeighborsCount);
    }

    public int countAliveNeighbors(int colIndex, int rowIndex) {
        int minColIndex = calculateMinColIndex(colIndex);
        int maxColIndex = calculateMaxColIndex(colIndex);
        int minRowIndex = calculateMinRowIndex(rowIndex);
        int maxRowIndex = calculateMaxRowIndex(rowIndex);

        int result = 0;

        for (int currentRowIndex = minRowIndex; currentRowIndex <= maxRowIndex; currentRowIndex++) {
            for (int currentColIndex = minColIndex; currentColIndex <= maxColIndex; currentColIndex++) {
                if (this.universe.getCell(currentColIndex, currentRowIndex).getState() == State.ALIVE) {
                    result++;
                }
            }
        }

        if (this.universe.getCell(colIndex, rowIndex).getState() == State.ALIVE) {
            result--;
        }
        return result;
    }

    private int calculateMaxRowIndex(int rowIndex) {
        if (rowIndex == this.universe.getHeight() - 1) {
            return rowIndex;
        }
        return rowIndex + 1;
    }

    private int calculateMinRowIndex(int rowIndex) {
        if (rowIndex == 0) {
            return rowIndex;
        }
        return rowIndex - 1;
    }

    private int calculateMaxColIndex(int colIndex) {
        if (colIndex == this.universe.getWidth() - 1) {
            return colIndex;
        }
        return colIndex + 1;
    }

    private int calculateMinColIndex(int colIndex) {
        if (colIndex == 0) {
            return colIndex;
        }
        return colIndex - 1;
    }
}
