package com.mingyaracosta;

import com.mingyaracosta.rules.AliveCellsRule;
import com.mingyaracosta.rules.IRule;

public class GameOfLifeEngine {

    private IRule firstRule;

    public GameOfLifeEngine() {
        this.firstRule = new AliveCellsRule();
    }

    Cell getCellForNextGeneration(Cell currentCell, int aliveNeighborsCount) {
        return this.firstRule.evaluate(currentCell, aliveNeighborsCount);
    }
}
