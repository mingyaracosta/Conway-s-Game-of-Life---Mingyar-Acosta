package com.mingyaracosta;

public class Cell {
    private static final State DEFAULT_STATE = State.ALIVE;
    private State state = DEFAULT_STATE;

    public Cell(State state) {
        this.state = state;
    }

    public Cell() {
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
