package com.mingyaracosta;

import com.mingyaracosta.testdependencypackage.Console;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Universe /*implements Cloneable */ {
    private static final int DEFAULT_HEIGHT = 10;
    private static final int DEFAULT_WIDTH = 10;

    private Random random = new Random();

    private Cell[][] cells;

    public Universe(int width, int height) {
        this.cells = new Cell[height][width];
    }

    public Universe() {
        this.cells = new Cell[Universe.DEFAULT_HEIGHT][Universe.DEFAULT_WIDTH];
    }

    public Universe(Universe universe) {
        this(universe.getWidth(), universe.getHeight());
        for (int rowIndex = 0; rowIndex < this.getHeight(); rowIndex++) {
            for (int colIndex = 0; colIndex < this.getWidth(); colIndex++) {
                this.cells[rowIndex][colIndex] = universe.getCell(colIndex, rowIndex).clone();
            }
        }
    }

    public int getHeight() {
        return this.cells.length;
    }

    public int getWidth() {
        return this.cells[0].length;
    }

    public void setCell(int col, int row, Cell cell) {
        this.cells[row][col] = cell;
    }

    public Cell getCell(int col, int row) {
        return this.cells[row][col];
    }

    public void initializeCells(State state) {
//        Console.print("Printing hello from test-dependency-package");
        for (int currentRow = 0; currentRow < this.getHeight(); currentRow++) {
            for (int currentCol = 0; currentCol < this.getWidth(); currentCol++) {
                this.cells[currentRow][currentCol] = new Cell(state);
            }
        }
    }

    public void initializeNRandomAliveCells(int aliveCellsQuantity) {
        initializeCells(State.DEAD);
        List<Integer> compoundIndexes = this.initilizeIndexesList();
        while (aliveCellsQuantity > 0) {
            int randomIndex = random.nextInt(compoundIndexes.size());
            int compoundIndex = compoundIndexes.get(randomIndex);
            int colIndex = getColIndexFromCompoundIndex(compoundIndex);
            int rowIndex = getRowIndexFromCompoundIndex(compoundIndex);
            this.cells[rowIndex][colIndex].setState(State.ALIVE);
            compoundIndexes.remove(randomIndex);
            aliveCellsQuantity--;
        }
    }

    private int getRowIndexFromCompoundIndex(int compoundIndex) {
        return compoundIndex / this.getWidth();
    }

    private int getColIndexFromCompoundIndex(int compoundIndex) {
        return compoundIndex % this.getWidth();
    }

    private List<Integer> initilizeIndexesList() {
        List<Integer> result = new LinkedList<>();
        int height = this.getHeight();
        int width = this.getWidth();
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int colIndex = 0; colIndex < width; colIndex++) {
                result.add(rowIndex * width + colIndex);
            }
        }
        return result;
    }

    public int getCellsByStateCount(State state) {
        int result = 0;
        for (int currentCol = 0; currentCol < this.getHeight(); currentCol++) {
            for (int currentRow = 0; currentRow < this.getWidth(); currentRow++) {
                if (cells[currentCol][currentRow].getState() == state) {
                    ++result;
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universe universe = (Universe) o;
        return Arrays.equals(cells, universe.cells);
    }

    @Override
    public Universe clone() {
        return new Universe(this);
    }

    @Override
    public String toString() {
        String result = "+";

        for (int i = 0; i < this.getWidth(); i++) {
            result += "--";
        }
        result += "-+\n";

        for (int i = 0; i < this.getHeight(); i++) {
            result += "|";
            for (int j = 0; j < this.getWidth(); j++) {
                if (this.cells[i][j].getState() == State.ALIVE) {
                    result += " 1";
                } else {
                    result += " 0";
                }
            }
            result += " |\n";
        }

        result += "+";
        for (int i = 0; i < this.getWidth(); i++) {
            result += "--";
        }
        result += "-+\n";

        return result;
    }
}
