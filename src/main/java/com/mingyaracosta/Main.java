package com.mingyaracosta;

import com.mingyaracosta.game.GameOfLifeEngine;

public class Main {
    private static final int ITARATIONS_NUMBER = 5;
    private static Universe universe;
    private static GameOfLifeEngine gameEngine;

    public static void main(String[] args) {
        initializeImmutableDispositionUniverse();
        gameEngine = new GameOfLifeEngine(universe);
        System.out.println(universe);
        for (int i = 0; i < ITARATIONS_NUMBER; i++) {
            universe = gameEngine.tick();
            System.out.println(universe);
        }
    }

    private static void initializeImmutableDispositionUniverse() {
        universe = new Universe(4, 4);
        universe.initializeCells(State.DEAD);
        universe.setCell(1, 1, new Cell(State.ALIVE));
        universe.setCell(2, 1, new Cell(State.ALIVE));
        universe.setCell(1, 2, new Cell(State.ALIVE));
        universe.setCell(2, 2, new Cell(State.ALIVE));
    }
}
