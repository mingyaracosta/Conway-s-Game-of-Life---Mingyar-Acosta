package com.mingyaracosta.rules;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;

public class AliveCellsRule extends IRuleImpl {
    @Override
    public Cell evaluate(Cell currentCell, int aliveNeighborsCount) {
        if (currentCell.getState() == State.ALIVE) {
            return new Cell(State.ALIVE);
        }
        return null;
    }
}
