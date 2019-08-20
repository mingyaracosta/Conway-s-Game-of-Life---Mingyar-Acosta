package com.mingyaracosta;

import java.util.List;

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
}
