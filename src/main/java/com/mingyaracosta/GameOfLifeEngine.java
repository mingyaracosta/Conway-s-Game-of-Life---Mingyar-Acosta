package com.mingyaracosta;

import com.mingyaracosta.rules.AliveCellsRule;
import com.mingyaracosta.rules.DeadCellsRule;
import com.mingyaracosta.rules.IRule;
import com.mingyaracosta.rules.IRuleImpl;

public class GameOfLifeEngine {

    private IRuleImpl firstRule;

    public GameOfLifeEngine() {
        this.firstRule = new DeadCellsRule();
        IRule secondRule = new AliveCellsRule();
        this.firstRule.setNextRule(secondRule);
    }

    Cell getCellForNextGeneration(Cell currentCell, int aliveNeighborsCount) {
        return this.firstRule.evaluate(currentCell, aliveNeighborsCount);
    }
}
