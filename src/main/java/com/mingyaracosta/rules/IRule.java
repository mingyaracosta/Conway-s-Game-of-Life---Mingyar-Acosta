package com.mingyaracosta.rules;

import com.mingyaracosta.Cell;

public interface IRule {

    Cell evaluate(Cell currentState, int aliveNeighborsCount);

    IRule nextRule();
}
