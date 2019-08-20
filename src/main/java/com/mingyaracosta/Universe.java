package com.mingyaracosta;

public class Universe {
    private static final int DEFAULT_HEIGHT = 10;
    private static final int DEFAULT_WIDTH = 10;

    private int height;
    private int width;

    private Cell[][] cells;

    public Universe(int width, int height) {
        this.cells = new Cell[height][width];
    }

    public Universe() {
        this.cells = new Cell[Universe.DEFAULT_HEIGHT][Universe.DEFAULT_WIDTH];
    }

    public int getHeight() {
        return this.cells.length;
    }

    public int getWidth() {
        return this.cells[0].length;
    }

    public void setCell(int col, int row, Cell cell) {
        this.cells[col][row] = cell;
    }

    public Cell getCell(int col, int row) {
        return this.cells[col][row];
    }

    public void initializeCells(State state) {
        for (int currentCol = 0; currentCol < this.getHeight(); currentCol++) {
            for (int currentRow = 0; currentRow < this.getWidth(); currentRow++) {
                cells[currentCol][currentRow] = new Cell(state);
            }
        }
    }

    public int getCellsAliveCount() {
        int result = 0;
        for (int currentCol = 0; currentCol < this.getHeight(); currentCol++) {
            for (int currentRow = 0; currentRow < this.getWidth(); currentRow++) {
                if (cells[currentCol][currentRow].getState() == State.ALIVE) {
                    ++result;
                }
            }
        }
        return result;
    }

//    public void
}
