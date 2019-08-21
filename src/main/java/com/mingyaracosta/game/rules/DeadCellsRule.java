package com.mingyaracosta.game.rules;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;

public class DeadCellsRule extends IRuleImpl {
    private static final int NUMBER_OF_NEIGHBORS_TO_BORN = 3;

    @Override
    public Cell evaluate(Cell currentCell, int aliveNeighborsCount) {
        if (currentCell.getState() == State.DEAD) {
            if (aliveNeighborsCount == NUMBER_OF_NEIGHBORS_TO_BORN) {
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
