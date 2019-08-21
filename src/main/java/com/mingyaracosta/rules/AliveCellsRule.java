package com.mingyaracosta.rules;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;

public class AliveCellsRule extends IRuleImpl {
    @Override
    public Cell evaluate(Cell currentCell, int aliveNeighborsCount) {
        if (currentCell.getState() == State.ALIVE) {
            if (aliveNeighborsCount == 2 || aliveNeighborsCount == 3) {
                return new Cell(State.ALIVE);
            }
            return new Cell(State.DEAD);
        }
        if (nextRule() != null) {
            return nextRule().evaluate(currentCell, aliveNeighborsCount);
        }
        return null;
    }
}
