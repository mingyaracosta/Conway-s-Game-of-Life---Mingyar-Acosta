package com.mingyaracosta;

import java.util.Objects;

public class Cell {
    private static final State DEFAULT_STATE = State.ALIVE;
    private State state = DEFAULT_STATE;

    public Cell(State state) {
        this.state = state;
    }

    public Cell() {
    }

    public Cell(Cell cell) {
        this(cell.state);
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

    @Override
    protected Cell clone() {
        return new Cell(this);
    }
}
