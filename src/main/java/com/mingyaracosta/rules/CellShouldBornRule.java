package com.mingyaracosta.rules;

import com.mingyaracosta.Cell;
import com.mingyaracosta.State;

public class CellShouldBornRule extends IRuleImpl {
    private static final int NUMBER_OF_NEIGHBORS_TO_BORN = 3;

    @Override
    public Cell evaluate(Cell currentState, int aliveNeighborsCount) {
        if (shouldItBorn(currentState, aliveNeighborsCount)) {
            return new Cell(State.ALIVE);
        }
        if (nextRule() != null) {
            return nextRule().evaluate(currentState, aliveNeighborsCount);
        }
        return null;
    }

    private boolean shouldItBorn(Cell currentState, int aliveNeighborsCount) {
        return currentState.getState() == State.DEAD
                && aliveNeighborsCount == NUMBER_OF_NEIGHBORS_TO_BORN;
    }
}
