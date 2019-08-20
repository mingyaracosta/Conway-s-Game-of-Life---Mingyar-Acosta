package com.mingyaracosta;

public class Cell {

    private State state = State.ALIVE;

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
}
